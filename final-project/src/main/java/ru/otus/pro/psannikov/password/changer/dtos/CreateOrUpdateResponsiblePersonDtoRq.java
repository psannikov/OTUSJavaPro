package ru.otus.pro.psannikov.password.changer.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateResponsiblePersonDtoRq {
    private Long id;
    private String fio;
    private String email;
}
