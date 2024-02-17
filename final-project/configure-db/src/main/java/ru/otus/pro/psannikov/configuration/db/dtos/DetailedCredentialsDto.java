package ru.otus.pro.psannikov.configuration.db.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DetailedCredentialsDto {
    private Long id;
    private String login;
    private String detail_credential_description;
    private String information_systems_name;
    private String rdbms_type;
    private String fio;
    private String email;
    private String status_description;
    private String secret;
}
