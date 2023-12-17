package ru.otus.pro.psannikov.spring.boot.security.https.sevices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Costumer;
import ru.otus.pro.psannikov.spring.boot.security.https.repositories.CostumersRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.CostumersService;

import java.util.Optional;

@Service
public class CostumersServiceImpl implements CostumersService {
    private final CostumersRepository costumersRepository;

    @Autowired
    public CostumersServiceImpl(CostumersRepository costumersRepository) {
        this.costumersRepository = costumersRepository;
    }

    @Override
    public Optional<Costumer> findById(Long id) {
        return costumersRepository.findById(id);
    }
}
