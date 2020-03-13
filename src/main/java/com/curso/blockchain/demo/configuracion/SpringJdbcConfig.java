package com.curso.blockchain.demo.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class SpringJdbcConfig {

    @Value("${driver-class-name")
    private String driver;
    @Value("${jdbcUrl")
    private String jdbcUrl;
    @Value("${username")
    private String userName;
    @Value("${password")
    private String password;

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/init");
        dataSource.setUsername("jonathan");
        dataSource.setPassword("jonathan");

        return dataSource;
    }
}
