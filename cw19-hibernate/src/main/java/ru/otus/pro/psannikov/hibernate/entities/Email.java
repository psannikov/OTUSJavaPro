package ru.otus.pro.psannikov.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @UuidGenerator
    private UUID id;

    private String inbox;

}
