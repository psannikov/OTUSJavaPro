package ru.otus.pro.psannikov.spring.boot.security.https.repositories;

import org.springframework.data.repository.ListCrudRepository;
import ru.otus.pro.psannikov.spring.boot.security.https.entities.Costumer;

public interface CostumersRepository extends ListCrudRepository<Costumer, Long> {
}
