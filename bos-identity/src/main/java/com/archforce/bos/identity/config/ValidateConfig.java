package com.archforce.bos.identity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 登录校验配置
 */
@Configuration
public class ValidateConfig {
    @Value("${identity.login.validateCode:#{''}}")
    private String validateSwitch;

}
