package ru.otus.pro.psannikov.spring.boot.security.https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Teacher;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.TeachersService;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeachersController {
    private final TeachersService teachersService;

    @Autowired
    public TeachersController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teachersService.findById(id).get();
    }
}
