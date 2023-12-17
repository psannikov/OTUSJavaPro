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
@Table("COSTUMERS")
public class Costumer {
    @Id
    private Long id;
    private String firstName;
    private String secondName;

    @PersistenceCreator
    public Costumer(Long id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
