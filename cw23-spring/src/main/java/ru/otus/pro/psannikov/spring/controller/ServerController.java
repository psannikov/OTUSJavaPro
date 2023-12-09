package ru.otus.pro.psannikov.spring.controller;

import ru.otus.pro.psannikov.spring.data.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ServerController {
    @Autowired
    RestTemplateBuilder templateBuilder;

    @RequestMapping("/info")
    public Info getInfo() {
        return new Info("Test Server", "1.0");
    }

    @RequestMapping("/auth")
    public void authorize() {
        RestTemplate template = templateBuilder
                .rootUri("http://localhost:9090")
                .build();

        HttpEntity<String> request = new HttpEntity<String>("login=service&password=password");

        ResponseEntity<String> entity = template.postForEntity("/auth", request, String.class);
        System.out.println(entity.getStatusCode());
    }
}
