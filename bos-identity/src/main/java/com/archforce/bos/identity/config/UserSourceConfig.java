package com.archforce.bos.identity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration

public class UserSourceConfig {

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "userdb.datasource")
    public DataSource domainConfigDataSource() {
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }
}
