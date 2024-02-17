package ru.otus.pro.psannikov.configuration.db.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.pro.psannikov.configuration.db.entities.InformationSystem;
import ru.otus.pro.psannikov.configuration.db.entities.ResponsiblePerson;
import ru.otus.pro.psannikov.configuration.db.entities.TaskStatus;

@Setter
@Getter
@NoArgsConstructor
public class CreateOrUpdateCredentialDtoRq {
    Long id;
    private String login;
    private String description;
    private InformationSystem informationSystem;
    private ResponsiblePerson responsiblePerson;
    private TaskStatus taskStatus;
}
