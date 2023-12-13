package ru.otus.pro.psannikov.spring.data.jdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("CATEGORIES")
@Getter
@Setter
public class Category {
    @Id
    private Long id;
    private String title;

    @PersistenceCreator
    public Category(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
