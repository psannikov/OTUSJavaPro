package ru.otus.pro.psannikov.configuration.db.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.pro.psannikov.configuration.db.entities.Credential;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateSecretDtoRq {
    private Long id;
    private Credential credential;
    private String secret;
}
