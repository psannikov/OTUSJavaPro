package ru.otus.pro.psannikov.jpql.crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
@Entity
public class Addres {
    @Id
    @SequenceGenerator(name = "addres_gen", sequenceName = "addres_seq",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addres_gen")
    @Column(name = "id")
    private long id;
    private String street;

    public Addres(String street) {
        this.street = street;
    }
}
