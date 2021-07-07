package com.archforce.bos.identity.config;

import com.archforce.bos.identity.filter.KaptchaFilter;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Properties;

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

    @Bean("defaultKaptcha")
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, Constants.KAPTCHA_SESSION_KEY);
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.archforce.bos.identity.utils.Noise");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "70");
        properties.setProperty(Constants.KAPTCHA_BORDER_THICKNESS, "1");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "127,96,0");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "27");
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
