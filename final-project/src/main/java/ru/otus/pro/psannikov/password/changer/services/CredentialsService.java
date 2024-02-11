package ru.otus.pro.psannikov.password.changer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateCredentialDtoRq;
import ru.otus.pro.psannikov.password.changer.dtos.DetailedCredentialsDto;
import ru.otus.pro.psannikov.password.changer.entities.Credential;
import ru.otus.pro.psannikov.password.changer.repositories.CredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialsService {
    private final CredentialsRepository credentialsRepository;

    @Autowired
    public CredentialsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public Optional<Credential> findById(Long id) {
        return credentialsRepository.findById(id);
    }

    public Optional<Credential> findByLogin(String login) {
        return credentialsRepository.findByLogin(login);
    }

    public Optional<DetailedCredentialsDto> findDetailedCredentialsById(Long id) {
        return credentialsRepository.findDetailedCredentialById(id);
    }

    public List<Credential> findAll() {
        return credentialsRepository.findAll();
    }

    public void createNewCredential(CreateOrUpdateCredentialDtoRq createOrUpdateCredentialDtoRq) {
        Credential newCredential = new Credential(createOrUpdateCredentialDtoRq.getId(),
                createOrUpdateCredentialDtoRq.getLogin(),
                createOrUpdateCredentialDtoRq.getDescription(),
                createOrUpdateCredentialDtoRq.getInformationSystem(),
                createOrUpdateCredentialDtoRq.getResponsiblePerson(),
                createOrUpdateCredentialDtoRq.getTaskStatus()
        );
        credentialsRepository.save(newCredential);
    }

    public void updateCredential(CreateOrUpdateCredentialDtoRq createOrUpdateCredentialDtoRq) {
        Credential updateCredential = new Credential(createOrUpdateCredentialDtoRq.getId(),
                createOrUpdateCredentialDtoRq.getLogin(),
                createOrUpdateCredentialDtoRq.getDescription(),
                createOrUpdateCredentialDtoRq.getInformationSystem(),
                createOrUpdateCredentialDtoRq.getResponsiblePerson(),
                createOrUpdateCredentialDtoRq.getTaskStatus());
        credentialsRepository.save(updateCredential);
    }

    public void nextStep(Long id) {
//        Optional<Credential> optionalCredential = credentialsRepository.findById(id);
//        Credential credential = optionalCredential.get();
//        if (credential.getId().equals(1L)) {
//            //TODO Реализация отправки письма
//            credential.setId(2L);
//        } else if (credential.getId().equals(2L)) {
//            //TODO Реализация генерации секрета
//            credential.setId(3L);
//        } else if (credential.getId().equals(3L)) {
//            //TODO Реализация передачи пароля
//            credential.setId(4L);
//        } else if (credential.getId().equals(4L)) {
//            //TODO Реализация обновления пароля
//            credential.setId(5L);
//        } else if (credential.getId().equals(5L)) {
//            //TODO Реализация уведомления о завершении и отчистки данных секретов
//            credential.setId(6L);
//        }
//        credentialsRepository.updateStepIdById(credential.getId(), credential.getTaskStatus().getId());
        credentialsRepository.updateStepIdById(1L, 3L);
    }

    public void deleteById(Long id) {
        credentialsRepository.deleteById(id);
    }
}
