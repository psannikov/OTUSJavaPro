package ru.otus.pro.psannikov.spring.boot.security.https.sevices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Subject;
import ru.otus.pro.psannikov.spring.boot.security.https.repositories.SubjectsRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.SubjectsService;

import java.util.Optional;

@Service
public class SubjectsServiceImpl implements SubjectsService {
    private final SubjectsRepository subjectsRepository;

    @Autowired
    public SubjectsServiceImpl(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectsRepository.findById(id);
    }
}
