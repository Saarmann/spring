package com.kaspar.spring.di.config;


import com.knits.spring.common.com.kaspar.demo.Customer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.knits.spring.common.com.kaspar.demo" })
public class CustomAppConfig {

    @Bean
    public BasicDataSource getDataSource() {

        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/team_taskmanagement");
        datasource.setUsername("root");
        datasource.setPassword("tere");
        datasource.setMinIdle(5);
        datasource.setMaxIdle(10);
        datasource.setMaxOpenPreparedStatements(100);
        return datasource;
    }

}
