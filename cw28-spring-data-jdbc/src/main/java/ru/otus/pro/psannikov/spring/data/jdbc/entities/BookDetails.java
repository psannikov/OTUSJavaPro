package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("BOOKS_DETAILS")
public class BookDetails {
    @Id
    private Long id;
    private Long bookId;
    private String description;

    @PersistenceCreator
    public BookDetails(Long id, Long bookId, String description) {
        this.id = id;
        this.bookId = bookId;
        this.description = description;
    }
}
