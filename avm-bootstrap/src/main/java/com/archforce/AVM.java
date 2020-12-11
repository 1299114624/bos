package com.archforce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.archforce.arc.facility.mapper")
public class AVM {

    public static void main(String[] args) {
        SpringApplication.run(AVM.class, args);
    }

}
