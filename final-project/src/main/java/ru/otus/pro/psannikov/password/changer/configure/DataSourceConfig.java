package ru.otus.pro.psannikov.password.changer.configure;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public Map<String, JdbcTemplate> dataSources() {
        Map<String, JdbcTemplate> dataSources = new HashMap<>();
        String prefix = "spring.otherdatasource";
        Properties properties = getAllKnownProperties(env);
        for (String key : properties.stringPropertyNames()) {
            if (key.startsWith(prefix)) {
                String dsName = key.substring(prefix.length() + 1, key.indexOf('.', prefix.length() + 1));
                if (!dataSources.containsKey(dsName)) {
                    DataSource dataSource = createDataSource(properties, prefix + "." + dsName);
                    dataSources.put(dsName, new JdbcTemplate(dataSource));
                }
            }
        }
        return dataSources;
    }

    private DataSource createDataSource(Properties properties, String baseKey) {
        String url = properties.getProperty(baseKey + ".url");
        String username = properties.getProperty(baseKey + ".username");
        String password = properties.getProperty(baseKey + ".password");
        String driverClassName = properties.getProperty(baseKey + ".driver-class-name");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    private Properties getAllKnownProperties(Environment env) {
        Properties props = new Properties();
        for (var propertySource : ((ConfigurableEnvironment) env).getPropertySources()) {
            if (propertySource instanceof EnumerablePropertySource) {
                for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
                    props.put(key, propertySource.getProperty(key));
                }
            }
        }
        return props;
    }
}