package com.archforce.bos.identity.filter;

import com.alibaba.fastjson.JSON;
import com.archforce.arc.common.log.LogUtils;
import com.google.code.kaptcha.Constants;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class KaptchaFilter extends FormAuthenticationFilter {
    private static final String OPEN = "1";

    private String validateSwitch;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        String captcha = (String) SecurityUtils.getSubject().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        LogUtils.info(getClass(), SecurityUtils.getSubject().getSession().getId().toString(), "");
        String inputCode = request.getParameter("code");
        // 用完之后直接清空
        SecurityUtils.getSubject().getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, null);
        // TODO 这里加开关
        if (OPEN.equals(validateSwitch) && (captcha == null || !captcha.equals(inputCode))) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("msg", "验证码错误");
            map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
            ServletOutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                response.setContentType("text/html;charset=utf-8");
                outputStream.write(JSON.toJSONString(map).getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

    public String getValidateSwitch() {
        return validateSwitch;
    }

    public void setValidateSwitch(String validateSwitch) {
        this.validateSwitch = validateSwitch;
    }
}
