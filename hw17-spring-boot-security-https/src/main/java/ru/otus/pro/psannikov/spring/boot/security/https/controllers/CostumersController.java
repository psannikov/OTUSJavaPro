package ru.otus.pro.psannikov.spring.boot.security.https.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Costumer;
import ru.otus.pro.psannikov.spring.boot.security.https.sevices.CostumersService;

@RestController
@RequestMapping("/api/v1/costumers")
public class CostumersController {
    private final CostumersService costumersService;

    @Autowired
    public CostumersController(CostumersService costumersService) {
        this.costumersService = costumersService;
    }

    @GetMapping("/{id}")
    public Costumer findById(@PathVariable Long id) {
        return costumersService.findById(id).get();
    }
}
