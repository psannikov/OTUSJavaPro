package ru.otus.pro.psannikov.password.changer.configure;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Qualifier("applicationProperties")
    @Autowired
    private ApplicationProperties dataSourceProperties;
    @Bean
    public Map<String, JdbcTemplate> dataSources() {
        Map<String, JdbcTemplate> dataSources = new HashMap<>();


        dataSourceProperties.getDataSources().forEach((k, v) -> {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(v.getUrl());
            dataSource.setUsername(v.getUsername());
            dataSource.setPassword(v.getPassword());
            dataSource.setDriverClassName(v.getDriverClassName());

            dataSources.put(k, new JdbcTemplate(dataSource));
            System.out.printf("created %s\t%s\n", k, dataSource);
        });
        return dataSources;
    }
}