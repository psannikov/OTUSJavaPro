package ru.otus.pro.psannikov.password.changer.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class ApplicationProperties {

    private Map<String, DataSourceConfig> dataSources;

    @Setter
    @Getter
    public static class DataSourceConfig {
        private String url;
        private String username;
        private String password;
        private String driverClassName;
    }
}