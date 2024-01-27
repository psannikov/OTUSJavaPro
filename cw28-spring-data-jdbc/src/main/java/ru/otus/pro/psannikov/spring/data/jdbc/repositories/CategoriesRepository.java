package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends ListCrudRepository<Category, Long> {
    @Query("select * from categories where title = :title")
    Optional<Category> myImplFindByTitle(String title);
    Optional<Category> findByTitle(String title);
    List<Category> findAllByTitleLike(String title);

}
