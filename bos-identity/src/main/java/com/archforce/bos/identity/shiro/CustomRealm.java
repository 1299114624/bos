package com.archforce.bos.identity.shiro;

import com.archforce.bos.identity.common.IdentityConstants;
import com.archforce.bos.identity.common.IdentityUtils;
import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.entity.User;
import com.archforce.bos.identity.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * 登录验证
 */
@Component(value = "customRealm")
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权信息 为当前登录的Subject授予角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = IdentityUtils.getSessionUser();
        info.setStringPermissions(new HashSet<>(user.getPermission()));
        List<Role> list = userService.getUserRolesById(user.getId());
        for (Role role : list) {
            info.addRole(role.getRoleName());
        }
        return info;
    }

    /**
     * 认证配置类
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        if (StringUtils.isNotEmpty(account)) {
            User user = userService.getUserPermission(account);
            if (null != user) {
                this.setSession(IdentityConstants.SESSION_USER, user);
                return new SimpleAuthenticationInfo(account, user.getPassword(), getName());
            }
        }
        return null;
    }

    /**
     * 将一些数据放到ShiroSession中，以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            Session session = subject.getSession();
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
