package ru.otus.pro.psannikov.password.changer.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.password.changer.entities.ResponsiblePerson;

import java.util.Optional;

public interface ResponsiblePersonsRepository extends ListCrudRepository<ResponsiblePerson, Long> {
    Optional<ResponsiblePerson> findByFio(String fio);
}
