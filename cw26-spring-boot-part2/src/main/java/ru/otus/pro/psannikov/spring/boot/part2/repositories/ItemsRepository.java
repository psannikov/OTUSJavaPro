package ru.otus.pro.psannikov.spring.boot.part2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.pro.psannikov.spring.boot.part2.entities.Item;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
}
