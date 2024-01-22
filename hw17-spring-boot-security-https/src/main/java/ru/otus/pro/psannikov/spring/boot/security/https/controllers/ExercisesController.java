package ru.otus.pro.psannikov.spring.boot.security.https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.ExerciseDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.ExercisesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
public class ExercisesController {
    private final ExercisesService exercisesService;

    @Autowired
    public ExercisesController(ExercisesService exercisesService) {
        this.exercisesService = exercisesService;
    }

    @GetMapping("/bysubject")
    public List<ExerciseDtoRq> findAllBySubjectId(@RequestParam Long id) {
        return exercisesService.findAllBySubjectId(id);
    }

    @GetMapping("/bycostumer")
    public List<ExerciseDtoRq> findAllByCostumerId(@RequestParam Long id) {
        return exercisesService.findAllByCostumerId(id);
    }

    @GetMapping("/byteacher")
    public List<ExerciseDtoRq> findAllByTeacherId(@RequestParam Long id) {
        return exercisesService.findAllByTeacherId(id);
    }
}
