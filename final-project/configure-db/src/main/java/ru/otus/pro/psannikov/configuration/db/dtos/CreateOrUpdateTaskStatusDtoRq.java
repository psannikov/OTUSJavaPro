package ru.otus.pro.psannikov.configuration.db.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateTaskStatusDtoRq {
    private Long id;
    private String description;
}
