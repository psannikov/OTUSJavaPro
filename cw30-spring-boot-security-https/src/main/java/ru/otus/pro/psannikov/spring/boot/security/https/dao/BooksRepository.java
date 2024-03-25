package ru.otus.pro.psannikov.spring.boot.security.https.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.boot.security.https.entity.Book;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {

}

