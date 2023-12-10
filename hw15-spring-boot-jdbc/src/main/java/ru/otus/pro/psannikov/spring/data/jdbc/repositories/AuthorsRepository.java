package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.flamexander.spring.data.jdbc.demo.entities.Author;

@Repository
public interface AuthorsRepository extends ListCrudRepository<Author, Long> {
}