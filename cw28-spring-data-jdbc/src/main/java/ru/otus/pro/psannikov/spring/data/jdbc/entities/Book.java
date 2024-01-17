package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("BOOKS")
public class Book {
    @Id
    private Long id;
    private String title;
    private Long authorId;
    @MappedCollection(idColumn = "BOOK_ID")
    private BookDetails bookDetails;
    private Genre genre;

    @PersistenceCreator
    public Book(Long id, String title, Long authorId, BookDetails bookDetails, Genre genre) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.bookDetails = bookDetails;
    }
}
