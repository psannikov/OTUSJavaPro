package ru.otus.pro.psannikov.spring.data.jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Author;
import ru.otus.pro.psannikov.spring.data.jdbc.services.AuthorsService;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorsController {
    private final AuthorsService authorsService;

    @Autowired
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorsService.findById(id).get();
    }
}
