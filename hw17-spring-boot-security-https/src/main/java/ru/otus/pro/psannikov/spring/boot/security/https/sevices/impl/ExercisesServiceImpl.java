package ru.otus.pro.psannikov.spring.boot.security.https.sevices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.ExerciseDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.repositories.ExercisesRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.ExercisesService;

import java.util.List;

@Service
public class ExercisesServiceImpl implements ExercisesService {
    private final ExercisesRepository exercisesRepository;

    @Autowired
    public ExercisesServiceImpl(ExercisesRepository exercisesRepository, RestTemplateBuilder templateBuilder) {
        this.exercisesRepository = exercisesRepository;
    }

    @Override
    public List<ExerciseDtoRq> findAllBySubjectId(Long id) {
        return exercisesRepository.findAllBySubjectId(id);
    }

    @Override
    public List<ExerciseDtoRq> findAllByCostumerId(Long id) {
        return exercisesRepository.findAllByCostumerId(id);
    }

    @Override
    public List<ExerciseDtoRq> findAllByTeacherId(Long id) {
        return exercisesRepository.findAllByTeacherId(id);
    }

}
