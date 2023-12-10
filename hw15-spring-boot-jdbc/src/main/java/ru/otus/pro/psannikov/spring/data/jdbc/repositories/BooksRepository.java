package ru.otus.pro.psannikov.spring.data.jdbc.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.data.jdbc.dtos.DetailedBookDto;
import ru.otus.pro.psannikov.spring.data.jdbc.entities.Book;

import java.util.List;

@Repository
public interface BooksRepository extends ListCrudRepository<Book, Long> {
    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description, ifnull (avg(r.rating),0) as avg_rating from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id" +
                    " left join REVIEWS r on r.book_id = b.id" +
                    " group by b.id, b.title, b.genre, a.full_name, bd.description"
    )
    List<DetailedBookDto> findAllDetailedBooks();

    @Query("update books set title = :title where id = :id")
    @Modifying
    void changeTitleById(Long id, String title);

    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description, ifnull (avg(r.rating),0) as avg_rating from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id" +
                    " left join REVIEWS r on r.book_id = b.id" +
                    " where b.id>:bookByPage * (:page - 1)" +
                    " and b.id<=:bookByPage * :page" +
                    " group by b.id, b.title, b.genre, a.full_name, bd.description"
    )
    List<DetailedBookDto> findAllDetailedBooksPagin(Long bookByPage, Long page);

    long count();

    @Query(
            "select b.id, b.title, b.genre, a.full_name as author_name, bd.description, ifnull (avg(r.rating),0) as avg_rating from BOOKS b " +
                    " left join AUTHORS a on b.author_id = a.id " +
                    " left join BOOKS_DETAILS bd on bd.book_id = b.id" +
                    " left join REVIEWS r on r.book_id = b.id" +
                    " where b.id = :id" +
                    " group by b.id, b.title, b.genre, a.full_name, bd.description"
    )
    DetailedBookDto findDetailedBooksById(Long id);

    @Query("select * from top10books")
    List<DetailedBookDto> findTop10BookByReview();
}