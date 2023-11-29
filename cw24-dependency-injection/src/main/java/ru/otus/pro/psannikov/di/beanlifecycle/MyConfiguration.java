package ru.otus.pro.psannikov.di.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class MyConfiguration {

    @Bean(initMethod = "beanInitMethod", destroyMethod = "beanDestroyMethod")
    public ExperimentImpl experiment() {
        return new ExperimentImpl();
    }
}
