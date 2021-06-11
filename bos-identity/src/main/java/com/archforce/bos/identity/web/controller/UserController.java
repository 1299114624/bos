package com.archforce.bos.identity.web.controller;

import com.alibaba.fastjson.JSON;
import com.archforce.arc.facility.exception.ApplicationException;
import com.archforce.arc.facility.log.LogTitle;
import com.archforce.arc.facility.log.LogUtils;
import com.archforce.arc.facility.utils.ResBody;
import com.archforce.bos.identity.common.IdentityConstants;
import com.archforce.bos.identity.common.IdentityUtils;
import com.archforce.bos.identity.entity.User;
import com.archforce.bos.identity.service.IdentityParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
