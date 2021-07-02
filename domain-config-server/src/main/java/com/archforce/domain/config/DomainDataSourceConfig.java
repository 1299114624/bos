package com.archforce.domain.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DomainDataSourceConfig {

    @Bean(name = "domainDataSource")
    @ConfigurationProperties(prefix = "domainconfigdb.datasource")
    public DataSource domainDataSource() {
        return DataSourceBuilder.create().build();
    }
}
