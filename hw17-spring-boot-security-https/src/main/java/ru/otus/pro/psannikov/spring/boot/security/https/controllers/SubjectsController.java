package ru.otus.pro.psannikov.spring.boot.security.https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.CreateOrUpdateSubjectDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Subject;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.SubjectsService;

import java.util.List;

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
    @GetMapping
    public List<Subject> findAll() {
        return subjectsService.findAll();
    }
    @PostMapping
    public void createNewSubject(@RequestBody CreateOrUpdateSubjectDtoRq createOrUpdateSubjectDtoRq) throws Exception {
        subjectsService.createNewSubject(createOrUpdateSubjectDtoRq);
    }
}
