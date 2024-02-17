package ru.otus.pro.psannikov.configuration.db.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.configuration.db.dtos.CreateOrUpdateInformationSystemDtoRq;
import ru.otus.pro.psannikov.configuration.db.entities.InformationSystem;
import ru.otus.pro.psannikov.configuration.db.repositories.InformationSystemsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InformationSystemsService {
    private final InformationSystemsRepository informationSystemsRepository;

    @Autowired
    public InformationSystemsService(InformationSystemsRepository informationSystemsRepository) {
        this.informationSystemsRepository = informationSystemsRepository;
    }

    public Optional<InformationSystem> findById(Long id) {
        return informationSystemsRepository.findById(id);
    }

    public Optional<InformationSystem> findByName(String name) {
        return informationSystemsRepository.findByName(name);
    }

    public List<InformationSystem> findAll() {
        return informationSystemsRepository.findAll();
    }

    public void createNewInformationSystem(CreateOrUpdateInformationSystemDtoRq createOrUpdateInformationSystemDtoRq) {
        InformationSystem newInformationSystem = new InformationSystem(createOrUpdateInformationSystemDtoRq.getId(),
                createOrUpdateInformationSystemDtoRq.getName(),
                createOrUpdateInformationSystemDtoRq.getRdbmsType(),
                createOrUpdateInformationSystemDtoRq.getUrl());
        informationSystemsRepository.save(newInformationSystem);
    }

    public void updateInformationSystem(CreateOrUpdateInformationSystemDtoRq createOrUpdateInformationSystemDtoRq) {
        InformationSystem updateInformationSystem = new InformationSystem(createOrUpdateInformationSystemDtoRq.getId(),
                createOrUpdateInformationSystemDtoRq.getName(),
                createOrUpdateInformationSystemDtoRq.getRdbmsType(),
                createOrUpdateInformationSystemDtoRq.getUrl());
        informationSystemsRepository.save(updateInformationSystem);
    }

    public void deleteById(Long id) {
        informationSystemsRepository.deleteById(id);
    }
}
