package ru.otus.pro.psannikov.password.changer.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.pro.psannikov.password.changer.entities.Credential;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateSecretDtoRq {
    private Long id;
    private Credential credential;
    private String secret;
}
