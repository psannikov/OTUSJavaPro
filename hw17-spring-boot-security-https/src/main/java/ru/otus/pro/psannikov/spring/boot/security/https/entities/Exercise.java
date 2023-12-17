package ru.otus.pro.psannikov.spring.boot.security.https.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
@Setter
@Getter
@Table("EXERCISES")
public class Exercise {
    @Id
    private Long id;
    private LocalDate exerciseDate;
    @MappedCollection(idColumn = "ID")
    private Subject subject;
    @MappedCollection(idColumn = "ID")
    private Costumer costumer;
    @MappedCollection(idColumn = "ID")
    private Teacher teacher;
}
