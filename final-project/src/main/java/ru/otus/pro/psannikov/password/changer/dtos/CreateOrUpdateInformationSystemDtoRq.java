package ru.otus.pro.psannikov.password.changer.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateInformationSystemDtoRq {
    private Long id;
    private String name;
    private String rdbmsType;
}
