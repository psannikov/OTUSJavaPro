package ru.otus.pro.psannikov.spring.boot.part1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.part1.ItemsInMemoryRepository;
import ru.otus.pro.psannikov.spring.boot.part1.entities.Item;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemsControllers {
    private final ItemsInMemoryRepository itemsInMemoryRepository;
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemsInMemoryRepository.getItemById(id);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemsInMemoryRepository.getAllItems();
    }
}
