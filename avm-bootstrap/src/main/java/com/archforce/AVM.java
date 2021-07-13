package com.archforce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.archforce.arc.facility.mapper")
//@ImportResource(locations={"classpath:xml/userDataSource.xml","classpath:xml/avmDataSource.xml"})
public class AVM {

    public static void main(String[] args) {
        SpringApplication.run(AVM.class, args);
    }

}
