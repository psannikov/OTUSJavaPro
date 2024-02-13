package ru.otus.pro.psannikov.password.changer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateCredentialDtoRq;
import ru.otus.pro.psannikov.password.changer.dtos.DetailedCredentialsDto;
import ru.otus.pro.psannikov.password.changer.entities.Credential;
import ru.otus.pro.psannikov.password.changer.services.rest.CredentialsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/credentials")
public class CredentialsController {
    private final CredentialsService credentialsService;

    @Autowired
    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    @GetMapping("/{id}")
    public Optional<Credential> findById(@PathVariable Long id) {
        return credentialsService.findById(id);
    }

    @GetMapping("/")
    public Optional<Credential> findByLogin(@RequestParam String login) {
        return credentialsService.findByLogin(login);
    }

    @GetMapping("/{id}/detail")
    public Optional<DetailedCredentialsDto> findDetailedCredentialsById(Long id) {
        return credentialsService.findDetailedCredentialsById(id);
    }

    @GetMapping
    public List<Credential> findAll() {
        return credentialsService.findAll();
    }

    @PostMapping
    public void createNewCredential(@RequestBody CreateOrUpdateCredentialDtoRq createOrUpdateCredentialDtoRq) {
        credentialsService.createNewCredential(createOrUpdateCredentialDtoRq);
    }

    @PutMapping
    public void updateCredential(@RequestBody CreateOrUpdateCredentialDtoRq createOrUpdateCredentialDtoRq) {
        credentialsService.updateCredential(createOrUpdateCredentialDtoRq);
    }

    @GetMapping("/{id}/next")
    public void nextStep(@PathVariable Long id) {
        credentialsService.nextStep(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        credentialsService.deleteById(id);
    }
}
