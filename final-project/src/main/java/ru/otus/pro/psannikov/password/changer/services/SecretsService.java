package ru.otus.pro.psannikov.password.changer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.password.changer.entities.Secret;
import ru.otus.pro.psannikov.password.changer.repositories.SecretsRepository;

import java.util.Optional;
@Service
public class SecretsService {
    private final SecretsRepository secretsRepository;

    @Autowired
    public SecretsService(SecretsRepository secretsRepository) {
        this.secretsRepository = secretsRepository;
    }
    public Optional<Secret> findById(Long id) {
        return secretsRepository.findById(id);
    }
    public void deleteById(Long id) {
        secretsRepository.deleteById(id);
    }
    public void deleteByCredentialId(Long credential_id) {
        secretsRepository.deleteByCredentialId(credential_id);
    }
}
