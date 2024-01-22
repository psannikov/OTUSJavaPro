package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Author;

public interface AuthorsRepository extends ListCrudRepository<Author, Long> {
}
