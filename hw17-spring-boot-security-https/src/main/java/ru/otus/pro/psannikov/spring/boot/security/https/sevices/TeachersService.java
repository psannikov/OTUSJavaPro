package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import ru.otus.pro.psannikov.spring.boot.security.https.entities.Teacher;

import java.util.Optional;

public interface TeachersService {
    Optional<Teacher> findById(Long id);
}
