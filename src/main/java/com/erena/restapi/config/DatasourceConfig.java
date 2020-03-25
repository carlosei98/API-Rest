package com.erena.restapi.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://aaz2lp6gi5zbye.cgmodfpdbwjw.us-east-1.rds.amazonaws.com/proyectociclo")
                .username("root")
                .password("rootroot")
                .build();
    }
}
