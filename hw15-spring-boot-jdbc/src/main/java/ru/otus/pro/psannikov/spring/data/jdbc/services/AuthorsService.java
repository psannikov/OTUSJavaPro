package ru.otus.pro.psannikov.spring.data.jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Author;
import ru.otus.pro.psannikov.spring.data.jdbc.repositories.AuthorsRepository;

import java.util.Optional;

@Service
public class AuthorsService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Optional<Author> findById(@PathVariable Long id) {
        return authorsRepository.findById(id);
    }
}
