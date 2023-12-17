package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import org.springframework.security.access.prepost.PreAuthorize;
import ru.otus.pro.psannikov.spring.boot.security.https.dtos.ExerciseDtoRq;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExercisesService {
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public List<ExerciseDtoRq> findAllBySubjectId(Long id);
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public List<ExerciseDtoRq> findAllByCostumerId(Long id);
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    public List<ExerciseDtoRq> findAllByTeacherId(Long id);
}
