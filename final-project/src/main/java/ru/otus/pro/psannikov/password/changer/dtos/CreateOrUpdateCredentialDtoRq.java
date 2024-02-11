package ru.otus.pro.psannikov.password.changer.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.otus.pro.psannikov.password.changer.entities.InformationSystem;
import ru.otus.pro.psannikov.password.changer.entities.ResponsiblePerson;
import ru.otus.pro.psannikov.password.changer.entities.TaskStatus;

@Setter
@Getter
public class CreateOrUpdateCredentialDtoRq {
    Long id;
    private String login;
    private String description;
    private InformationSystem informationSystem;
    private ResponsiblePerson responsiblePerson;
    private TaskStatus taskStatus;

    public CreateOrUpdateCredentialDtoRq() {
    }
}
