package ru.otus.pro.psannikov.spring.boot.security.https.sevices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Teacher;
import ru.otus.pro.psannikov.spring.boot.security.https.repositories.TeachersRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.TeachersService;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeachersService {
    private final TeachersRepository teachersRepository;

    @Autowired
    public TeacherServiceImpl(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teachersRepository.findById(id);
    }
}
