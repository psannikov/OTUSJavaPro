package ru.otus.pro.psannikov.configuration.db.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.configuration.db.entities.InformationSystem;

import java.util.Optional;

public interface InformationSystemsRepository extends ListCrudRepository<InformationSystem, Long> {
    Optional<InformationSystem> findByName(String name);
}
