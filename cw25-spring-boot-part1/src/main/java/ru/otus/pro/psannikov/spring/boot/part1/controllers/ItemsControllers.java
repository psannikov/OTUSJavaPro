package ru.otus.pro.psannikov.spring.boot.part1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.pro.psannikov.spring.boot.part1.model.Item;

@RestController
public class ItemsControllers {
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Long id) {
        return new Item(id, "Item #" + id, 100);
    }
}
