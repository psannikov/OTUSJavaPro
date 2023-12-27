package ru.otus.pro.psannikov.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(registry -> {
                    registry.anyRequest().authenticated();
                })
               .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));

//                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
