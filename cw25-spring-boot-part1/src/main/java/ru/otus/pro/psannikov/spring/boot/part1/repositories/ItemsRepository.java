package ru.otus.pro.psannikov.spring.boot.part1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.boot.part1.entities.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
}
