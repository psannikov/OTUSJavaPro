package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import ru.otus.pro.psannikov.spring.boot.security.https.entities.Subject;

import java.util.Optional;

public interface SubjectsService {
    public Optional<Subject> findById(Long id);
}
