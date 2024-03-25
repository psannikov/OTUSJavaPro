package ru.otus.pro.psannikov.password.changer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.password.changer.dtos.CreateOrUpdateInformationSystemDtoRq;
import ru.otus.pro.psannikov.password.changer.entities.InformationSystem;
import ru.otus.pro.psannikov.password.changer.services.rest.InformationSystemsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/information_system")
public class InformationSystemsController {
    private final InformationSystemsService informationSystemsService;

    @Autowired
    public InformationSystemsController(InformationSystemsService informationSystemsService) {
        this.informationSystemsService = informationSystemsService;
    }

    @GetMapping("/{id}")
    public Optional<InformationSystem> findById(@PathVariable Long id) {
        return informationSystemsService.findById(id);
    }

    @GetMapping("/")
    public Optional<InformationSystem> findByName(@RequestParam String login) {
        return informationSystemsService.findByName(login);
    }

    @GetMapping
    public List<InformationSystem> findAll() {
        return informationSystemsService.findAll();
    }

    @PostMapping
    public void createNewInformationSystem(@RequestBody CreateOrUpdateInformationSystemDtoRq createOrUpdateInformationSystemDtoRq) {
        informationSystemsService.createNewInformationSystem(createOrUpdateInformationSystemDtoRq);
    }

    @PutMapping
    public void updateInformationSystem(@RequestBody CreateOrUpdateInformationSystemDtoRq createOrUpdateInformationSystemDtoRq) {
        informationSystemsService.updateInformationSystem(createOrUpdateInformationSystemDtoRq);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        informationSystemsService.deleteById(id);
    }
}
