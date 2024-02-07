package ru.otus.pro.psannikov.spring.data.jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Author;

import java.util.Optional;

public interface AuthorsService {
    public Optional<Author> findById(Long id);
}
