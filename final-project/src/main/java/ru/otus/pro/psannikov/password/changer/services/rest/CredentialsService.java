package ru.otus.pro.psannikov.password.changer.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateCredentialDtoRq;
import ru.otus.pro.psannikov.password.changer.dtos.DetailedCredentialsDto;
import ru.otus.pro.psannikov.password.changer.entities.Credential;
import ru.otus.pro.psannikov.password.changer.repositories.CredentialsRepository;
import ru.otus.pro.psannikov.password.changer.repositories.SecretsRepository;
import ru.otus.pro.psannikov.password.changer.services.external.EmailSenderService;
import ru.otus.pro.psannikov.password.changer.services.external.TelegramBotService;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialsService {
    @Value("${spring.mail.subject}")
    private String subject;
    private final CredentialsRepository credentialsRepository;
    private final SecretsRepository secretsRepository;
    private final EmailSenderService senderService;
    private final TaskStatusService taskStatusService;
    private final TelegramBotService telegramBotService;

    @Autowired
    public CredentialsService(CredentialsRepository credentialsRepository, SecretsRepository secretsRepository, EmailSenderService senderService, TaskStatusService taskStatusService, TelegramBotService telegramBotService) {
        this.credentialsRepository = credentialsRepository;
        this.secretsRepository = secretsRepository;
        this.senderService = senderService;
        this.taskStatusService = taskStatusService;
        this.telegramBotService = telegramBotService;
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
        Optional<Credential> optionalCredential = credentialsRepository.findById(id);
        Credential credential = optionalCredential.get();
        if (credential.getTaskStatus().getId().equals(1L)) {
            Context context = new Context();
            context.setVariable("fio", credential.getResponsiblePerson().getFio());
            context.setVariable("description", credential.getDescription());
            context.setVariable("login", credential.getLogin());
            senderService.sendEmail(credential.getResponsiblePerson().getEmail(),subject, context);
            credential.setTaskStatus(taskStatusService.findById(2L).get());
        } else if (credential.getTaskStatus().getId().equals(2L)) {
            secretsRepository.insertNewSecret(credential.getId(), credential.getDescription());
            credential.setTaskStatus(taskStatusService.findById(3L).get());
        } else if (credential.getTaskStatus().getId().equals(3L)) {
            //TODO тут будет реализация вызова API секретной передачи конф информации,
            // это я буду делать уже после завершения проекта, пока просто двигаем статус
            credential.setTaskStatus(taskStatusService.findById(4L).get());
        } else if (credential.getTaskStatus().getId().equals(4L)) {
            //TODO Реализация обновления пароля ну и работа с несколькими базами одновременно
            credential.setTaskStatus(taskStatusService.findById(5L).get());
        } else if (credential.getTaskStatus().getId().equals(5L)) {
            telegramBotService.onUpdateReceived(new Update());
            secretsRepository.deleteByCredentialId(credential.getId());
            credential.setTaskStatus(taskStatusService.findById(6L).get());
        }
        credentialsRepository.save(credential);
    }

    public void deleteById(Long id) {
        credentialsRepository.deleteById(id);
    }
}
