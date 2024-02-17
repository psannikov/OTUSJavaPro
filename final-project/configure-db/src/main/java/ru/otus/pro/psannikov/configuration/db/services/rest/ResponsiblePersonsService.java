package ru.otus.pro.psannikov.configuration.db.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.configuration.db.dtos.CreateOrUpdateResponsiblePersonDtoRq;
import ru.otus.pro.psannikov.configuration.db.entities.ResponsiblePerson;
import ru.otus.pro.psannikov.configuration.db.repositories.ResponsiblePersonsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsiblePersonsService {
    private final ResponsiblePersonsRepository responsiblePersonsRepository;

    @Autowired
    public ResponsiblePersonsService(ResponsiblePersonsRepository responsiblePersonsRepository) {
        this.responsiblePersonsRepository = responsiblePersonsRepository;
    }

    public Optional<ResponsiblePerson> findById(Long id) {
        return responsiblePersonsRepository.findById(id);
    }

    public Optional<ResponsiblePerson> findByFio(String fio) {
        return responsiblePersonsRepository.findByFio(fio);
    }

    public List<ResponsiblePerson> findAll() {
        return responsiblePersonsRepository.findAll();
    }

    public void createNewResponsiblePerson(CreateOrUpdateResponsiblePersonDtoRq createOrUpdateResponsiblePersonDtoRq) {
        ResponsiblePerson newResponsiblePerson = new ResponsiblePerson(createOrUpdateResponsiblePersonDtoRq.getId(),
                createOrUpdateResponsiblePersonDtoRq.getFio(),
                createOrUpdateResponsiblePersonDtoRq.getEmail());
        responsiblePersonsRepository.save(newResponsiblePerson);
    }

    public void updateResponsiblePerson(CreateOrUpdateResponsiblePersonDtoRq createOrUpdateResponsiblePersonDtoRq) {
        ResponsiblePerson newResponsiblePerson = new ResponsiblePerson(createOrUpdateResponsiblePersonDtoRq.getId(),
                createOrUpdateResponsiblePersonDtoRq.getFio(),
                createOrUpdateResponsiblePersonDtoRq.getEmail());
        responsiblePersonsRepository.save(newResponsiblePerson);
    }

    public void deleteById(Long id) {
        responsiblePersonsRepository.deleteById(id);
    }
}
