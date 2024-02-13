package ru.otus.pro.psannikov.password.changer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.password.changer.entities.Secret;
import ru.otus.pro.psannikov.password.changer.services.rest.SecretsService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/secrets")
public class SecretsController {
    private final SecretsService secretsService;

    @Autowired
    public SecretsController(SecretsService secretsService) {
        this.secretsService = secretsService;
    }

    @GetMapping("/{id}")
    public Optional<Secret> findById(@PathVariable Long id) {
        return secretsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        secretsService.deleteById(id);
    }

    @DeleteMapping("/")
    public void deleteByCredentialId(@RequestParam Long id) {
        secretsService.deleteByCredentialId(id);
    }
}
