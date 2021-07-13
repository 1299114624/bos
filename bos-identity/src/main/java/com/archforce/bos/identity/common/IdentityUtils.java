package com.archforce.bos.identity.common;

import com.archforce.common.exception.ApplicationException;
import com.archforce.bos.identity.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class IdentityUtils {
    public static User getSessionUser() {
        User user;
        try {
            user = (User) getShiroSession().getAttribute(IdentityConstants.SESSION_USER);
        } catch (Exception e) {
            throw new ApplicationException("10004");
        }
        if (user == null) {
            throw new ApplicationException("10004");
        }
        return user;
    }

    /**
     * 获取 shiro session
     */
    public static Session getShiroSession() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return session;
    }
}
