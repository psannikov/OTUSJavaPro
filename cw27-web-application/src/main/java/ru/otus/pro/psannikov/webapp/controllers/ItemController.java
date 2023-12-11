package ru.otus.pro.psannikov.webapp.controllers;

import ru.otus.pro.psannikov.webapp.models.Item;
import ru.otus.pro.psannikov.webapp.services.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Collection<Item> all() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Item one(@PathVariable String id) {
        return itemService.getOne(Integer.valueOf(id));
    }

    @PostMapping
    public Item create(@RequestBody String name) {
        return itemService.createOne(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return itemService.deleteOne(Integer.valueOf(id));
    }

    @PutMapping ("/{id}")
    public String update(@PathVariable String id, @RequestParam String name) {
        return itemService.updateOne(Integer.valueOf(id), name);
    }

}