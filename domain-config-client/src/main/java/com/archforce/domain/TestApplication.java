package com.archforce.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestApplication {
    @Value("${file.size}")
    private String fileSize;

    private static String fileSizeFinal;

    @PostConstruct
    public void init() {
        fileSizeFinal = fileSize;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);
        System.out.println(run.getEnvironment().getProperty("file.size"));
        System.out.println(fileSizeFinal);
    }
}
