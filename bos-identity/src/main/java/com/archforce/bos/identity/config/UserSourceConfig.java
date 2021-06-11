package com.archforce.bos.identity.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class UserSourceConfig {
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "userdb.datasource")
    public DataSource domainConfigDataSource() {
        return DataSourceBuilder.create().build();
    }
}
