package ru.otus.pro.psannikov.password.changer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateResponsiblePersonDtoRq;
import ru.otus.pro.psannikov.password.changer.entities.ResponsiblePerson;
import ru.otus.pro.psannikov.password.changer.services.ResponsiblePersonsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/responsible_persons")
public class ResponsiblePersonsController {
    private final ResponsiblePersonsService responsiblePersonsService;

    @Autowired
    public ResponsiblePersonsController(ResponsiblePersonsService responsiblePersonsService) {
        this.responsiblePersonsService = responsiblePersonsService;
    }

    @GetMapping("/{id}")
    public Optional<ResponsiblePerson> findById(@PathVariable Long id) {
        return responsiblePersonsService.findById(id);
    }

    @GetMapping("/")
    public Optional<ResponsiblePerson> findByName(@RequestParam String fio) {
        return responsiblePersonsService.findByFio(fio);
    }

    @GetMapping
    public List<ResponsiblePerson> findAll() {
        return responsiblePersonsService.findAll();
    }

    @PostMapping
    public void createNewResponsiblePerson(@RequestBody CreateOrUpdateResponsiblePersonDtoRq createOrUpdateResponsiblePersonDtoRq) {
        responsiblePersonsService.createNewResponsiblePerson(createOrUpdateResponsiblePersonDtoRq);
    }

    @PutMapping
    public void updateResponsiblePerson(@RequestBody CreateOrUpdateResponsiblePersonDtoRq createOrUpdateResponsiblePersonDtoRq) {
        responsiblePersonsService.updateResponsiblePerson(createOrUpdateResponsiblePersonDtoRq);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        responsiblePersonsService.deleteById(id);
    }
}
