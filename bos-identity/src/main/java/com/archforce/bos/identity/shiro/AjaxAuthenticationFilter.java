package com.archforce.bos.identity.shiro;

import com.archforce.common.log.LogUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


/**
 * 登录拦截
 */
public class AjaxAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(AjaxAuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    LogUtils.trace(AjaxAuthenticationFilter.class, "登录拦截告警信息", "Login submission detected.  Attempting to execute login.");
                }
                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    LogUtils.trace(AjaxAuthenticationFilter.class, "登录拦截告警信息", "Login page view.");
                }
                // allow them to see the login page
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                LogUtils.trace(AjaxAuthenticationFilter.class, "登录拦截告警信息", "Attempting to access a path which requires authentication.  Forwarding to the Authentication url [" + this.getLoginUrl() + "]");
            }
            WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter out = response.getWriter();
            out.println("{\n" +
                    "\"code\": \"10004\",\n" +
                    "\"msg\": \"no login user\"\n" +
                    "}");
            out.close();
//            this.saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }

}
