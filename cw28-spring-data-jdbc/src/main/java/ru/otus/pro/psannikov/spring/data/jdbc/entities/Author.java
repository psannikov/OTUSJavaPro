package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
@Setter
@Getter
@Table("AUTHORS")
public class Author {
    @Id
    private Long id;
    private String fullName;
    @MappedCollection(idColumn = "AUTHOR_ID")
    private Set<Book> books;

    @PersistenceCreator
    public Author(Long id, String fullName, Set<Book> books) {
        this.id = id;
        this.fullName = fullName;
        this.books = books;
    }
}
