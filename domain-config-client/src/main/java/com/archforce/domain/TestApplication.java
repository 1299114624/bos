package com.archforce.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestApplication {
    @Value("${identity.expireTime}")
    private Long expireTime;

    private static Long expireTimeFinal;

    @PostConstruct
    public void init() {
        expireTimeFinal = expireTime;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);
        System.out.println(run.getEnvironment().getProperty("identity.expireTime"));
        System.out.println(expireTimeFinal);
    }
}
