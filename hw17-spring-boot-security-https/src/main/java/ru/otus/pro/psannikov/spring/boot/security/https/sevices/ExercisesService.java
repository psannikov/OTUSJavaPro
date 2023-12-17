package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import ru.otus.pro.psannikov.spring.boot.security.https.dtos.ExerciseDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExercisesService {
    public List<ExerciseDtoRq> findAllBySubjectId(Long id);
    public List<ExerciseDtoRq> findAllByCostumerId(Long id);
    public List<ExerciseDtoRq> findAllByTeacherId(Long id);
}
