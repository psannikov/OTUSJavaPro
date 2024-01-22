package ru.otus.pro.psannikov.spring.boot.security.https.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrUpdateSubjectDtoRq {
    private Long id;
    private String name;
    private String description;
}
