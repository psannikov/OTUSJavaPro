package ru.otus.pro.psannikov.spring.boot.security.https.sevices;

import ru.otus.pro.psannikov.spring.boot.security.https.entities.Costumer;

import java.util.Optional;

public interface CostumersService {
    public Optional<Costumer> findById(Long id);
}
