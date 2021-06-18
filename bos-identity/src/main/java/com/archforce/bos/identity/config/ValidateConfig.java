package com.archforce.bos.identity.config;

import com.archforce.bos.identity.filter.KaptchaFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 登录校验配置
 */
@Configuration
public class ValidateConfig {
    @Value("${identity.login.validateCode:#{''}}")
    private String validateSwitch;

    @Bean
    public Filter kaptchaFilter() {
        KaptchaFilter kaptchaFilter = new KaptchaFilter();
        kaptchaFilter.setValidateSwitch(validateSwitch);
        return kaptchaFilter;
    }
}
