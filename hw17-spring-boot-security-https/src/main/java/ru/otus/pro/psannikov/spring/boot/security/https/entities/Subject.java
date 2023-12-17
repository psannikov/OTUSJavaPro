package ru.otus.pro.psannikov.spring.boot.security.https.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Setter
@Getter
@Table("SUBJECTS")
public class Subject {
    @Id
    private Long id;
    private String name;
    private String description;

    @PersistenceCreator
    public Subject(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
