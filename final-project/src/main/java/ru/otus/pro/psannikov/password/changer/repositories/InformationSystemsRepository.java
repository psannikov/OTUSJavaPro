package ru.otus.pro.psannikov.password.changer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.password.changer.entities.InformationSystem;

import java.util.Optional;

public interface InformationSystemsRepository extends ListCrudRepository<InformationSystem, Long> {
    Optional<InformationSystem> findByName(String name);
}
