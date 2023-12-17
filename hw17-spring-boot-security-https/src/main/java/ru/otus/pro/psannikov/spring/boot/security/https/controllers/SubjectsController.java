package ru.otus.pro.psannikov.spring.boot.security.https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Subject;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.SubjectsService;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectsController {
    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return subjectsService.findById(id).get();
    }
}
