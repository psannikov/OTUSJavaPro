package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Book;

import java.util.List;

public interface BooksRepository extends ListCrudRepository<Book, Long> {
    @Query("select b.id, b.title, b.genre, a.full_name as author_name, bd.description from BOOKS b " +
            " left join AUTHORS a on b.author_id = a.id " +
            " left join BOOKS_DETAILS bd on bd.book_id = b.id")
    List<DetailedBookDto> findAllDetailedBooks();
@Query("update books set title = :title where id = :id")
@Modifying
    void changeTitleById(Long id, String title);
}
