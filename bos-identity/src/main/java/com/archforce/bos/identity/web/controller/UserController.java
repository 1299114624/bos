package com.archforce.bos.identity.web.controller;

import com.alibaba.fastjson.JSON;
import com.archforce.arc.facility.exception.ApplicationException;
import com.archforce.arc.facility.log.LogTitle;
import com.archforce.arc.facility.log.LogUtils;
import com.archforce.arc.facility.utils.Encrypt;
import com.archforce.arc.facility.utils.ResBody;
import com.archforce.bos.identity.common.IdentityConstants;
import com.archforce.bos.identity.common.IdentityUtils;
import com.archforce.bos.identity.entity.LoginInfo;
import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.entity.User;
import com.archforce.bos.identity.service.IdentityParameterService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 用户管理 Controller
 */
@RestController
public class UserController {
    /**
     * BOS参数服务类
     */
    @Autowired
    private Map<String, IdentityParameterService> parameterServiceMap;

    private Map<Integer, Integer> roleTypeMap = new HashMap<>();

    /**
     * 获取当前登录方式
     */
    @PostMapping("/getLoginType")
    public ResBody getLoginType() {
        Map<String, String> map = new HashMap<>();
        String loginType = getParameterService(IdentityConstants.PARAMETER_BOS_CONFIG_LOGIN_TYPE);
        map.put("loginType", loginType);
        IdentityConstants.GLOBAL_LOGIN_TYPE = loginType;
        // SSO登录模式待开发

        return ResBody.ok(JSON.toJSON(map));
    }

    @PostMapping("/identity/userInfo")
    public ResBody getCurrentUser() {
        User user = IdentityUtils.getSessionUser();
        if (Objects.isNull(user)) {
            throw new ApplicationException("10004");
        }
        user.setPassword("");
        return ResBody.ok(user);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResBody login(@RequestParam String username, @RequestParam String password) {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserName(username);
        loginInfo.setPassword(password);
        String loginType = getParameterService(IdentityConstants.PARAMETER_BOS_CONFIG_LOGIN_TYPE);
        IdentityConstants.GLOBAL_LOGIN_TYPE = loginType;
        if (IdentityConstants.SSO_LOGIN_TYPE_BOS.equals(loginType) || specialUserList(loginInfo.getUserName())) {
            loginInfo = decodePassword(loginInfo);
            return userLogin(loginInfo, loginType);
        }
        return ssoLogin(loginInfo);
    }

    /**
     * BOS登录方式
     */
    private ResBody userLogin(LoginInfo loginInfo, String loginType) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        try {
            if (specialUserList(loginInfo.getUserName()) || IdentityConstants.SSO_LOGIN_TYPE_BOS.equals(loginType) || IdentityConstants.SSO_LOGIN_TYPE_CUSTOM_PASSWORD.equals(loginType)) {
                Serializable id = session.getId();
                subject.login(new UsernamePasswordToken(loginInfo.getUserName(), Encrypt.SHA256(loginInfo.getPassword())));
            } else {
                subject.login(new UsernamePasswordToken(loginInfo.getUserName(), loginInfo.getPassword()));
            }
            initSessionUser(loginInfo, session);
        } catch (AuthenticationException e) {
            session.removeAttribute(IdentityConstants.SESSION_USER);
            LogUtils.info(UserController.class, "登录时用户名或者密码错误", loginInfo.getUserName() + " close, login failed");
            return ResBody.error(new ApplicationException("10002"));
        } catch (Exception e) {
            Serializable id = session.getId();
            e.printStackTrace();
        }
        return ResBody.ok(IdentityUtils.getSessionUser());
    }

    /**
     * SSO登录方式
     */
    private ResBody ssoLogin(LoginInfo loginInfo) {
        return ResBody.ok();
    }

    public void initSessionUser(LoginInfo loginInfo, Session session) {
        User user;
        user = (User) session.getAttribute(IdentityConstants.SESSION_USER);
        if (!CollectionUtils.isEmpty(roleTypeMap)) {
            for (Role role : user.getRoles()) {
                if (roleTypeMap.containsKey(role.getBusinessType())) {
                    user.setIsQueryHomeData(true);
                    break;
                }
            }
        } else {
            user.setIsQueryHomeData(true);
        }
        // 受限用户
        if (Objects.nonNull(user.getIsLimit()) && user.getIsLimit()) {
            session.removeAttribute(IdentityConstants.SESSION_USER);
            LogUtils.info(UserController.class, "受限用户登录系统告警", loginInfo.getUserName() + "limit is 1 login failed");
            throw new ApplicationException("10003");
        }
        // 已注销用户
        if (Objects.nonNull(user.getIsClose()) && user.getIsClose()) {
            session.removeAttribute(IdentityConstants.SESSION_USER);
            LogUtils.info(UserController.class, "已注销用户登录系统告警", loginInfo.getUserName() + "close is 1 login failed");
            throw new ApplicationException("10015");
        }
        session.setAttribute(IdentityConstants.SESSION_USER, user);
    }


    /**
     * 判断是否是特殊用户
     */
    private Boolean specialUserList(String userName) {
        String userList = getParameterService(IdentityConstants.PARAMETER_SSO_CONFIG_SPECIALUSERLIST);
        if (StringUtils.isEmpty(userList)) {
            return false;
        }
        Boolean result = false;
        List<String> datas = Arrays.asList(userList.split(","));
        for (String item : datas) {
            if (userName.equals(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 解码用户信息
     */
    private LoginInfo decodePassword(LoginInfo loginInfo) {
        try {
            loginInfo.setPassword(new String(Base64.getDecoder().decode(getOffsetPassword(loginInfo.getPassword(), -2)), "UTF-8"));
        } catch (Exception e) {
            LogUtils.info(UserController.class, LogTitle.RUN_TIME_ERROR, "用户：" + loginInfo.getUserName() + "解码用户信息失败",e);
        }
        return loginInfo;
    }

    private String getOffsetPassword(String password, int offset) {
        char[] chars = password.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int newOffset = ((int) chars[i]) + offset;
            char c = (char) newOffset;
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 获取参数值
     * @param paraName
     * @return
     */
    private String getParameterService(String paraName) {
        IdentityParameterService identityParameterService = parameterServiceMap.get("IdentityParameterService");
        if (identityParameterService == null) {
            LogUtils.warn(UserController.class, LogTitle.RUN_TIME_WARNING, "没有获取参数的服务");
            return "";
        }
        String parameterValue = identityParameterService.getParameterValue(paraName);
        return parameterValue;
    }
}
