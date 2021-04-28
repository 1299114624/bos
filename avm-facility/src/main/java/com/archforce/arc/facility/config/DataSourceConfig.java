package com.archforce.arc.facility.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "avmDataSource")
    @Primary
    @ConfigurationProperties(prefix = "avmdb.datasource")
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create().build();
        return dataSource;
    }

    @Bean(name = "zentaoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.zentao")
    public DataSource zentaoDataSource() {
        return DataSourceBuilder.create().build();
    }
}
