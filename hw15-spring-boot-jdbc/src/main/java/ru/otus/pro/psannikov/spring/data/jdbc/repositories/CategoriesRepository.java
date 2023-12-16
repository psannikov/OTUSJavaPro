package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Category;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends ListCrudRepository<Category, Long> {

    Optional<Category> findByTitle(String title);
}