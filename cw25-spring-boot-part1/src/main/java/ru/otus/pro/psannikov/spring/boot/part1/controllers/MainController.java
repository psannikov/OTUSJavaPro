package ru.otus.pro.psannikov.spring.boot.part1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/add")
    public Integer calcSum (@RequestParam(defaultValue = "0", name = "add_value_first") Integer a, @RequestParam(defaultValue = "0", required = false) Integer b) {
        return a + b;
    }
}
