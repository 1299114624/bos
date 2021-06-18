package com.archforce.bos.identity.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class KaptchaFilter extends FormAuthenticationFilter {
    private static final String OPEN = "1";

    private String validateSwitch;

    public String getValidateSwitch() {
        return validateSwitch;
    }

    public void setValidateSwitch(String validateSwitch) {
        this.validateSwitch = validateSwitch;
    }
}
