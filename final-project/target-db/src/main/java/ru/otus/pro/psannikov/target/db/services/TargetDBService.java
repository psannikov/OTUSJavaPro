package ru.otus.pro.psannikov.target.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.target.db.entities.Auth;
import ru.otus.pro.psannikov.target.db.repositories.TargetDBRepository;

import java.util.Optional;

@Service
public class TargetDBService {
    private final TargetDBRepository targetDBRepository;

    @Autowired
    public TargetDBService(TargetDBRepository targetDBRepository) {
        this.targetDBRepository = targetDBRepository;
    }

    public Optional<Auth> findById(Long id) {
        return targetDBRepository.findById(id);
    }

    public String changePassword(String login, String password) {
        return targetDBRepository.changePassword(login, password);
    }

    public Optional<Auth> checkAuth(String login) {
        return targetDBRepository.checkAuth(login);
    }
}
