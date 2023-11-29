package ru.otus.pro.psannikov.spring.boot.part1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.spring.boot.part1.dtos.ItemDto;
import ru.otus.pro.psannikov.spring.boot.part1.entities.Item;
import ru.otus.pro.psannikov.spring.boot.part1.repositories.ItemsRepository;
import ru.otus.pro.psannikov.spring.boot.part1.services.ItemsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemsControllers {
    private final ItemsService itemsService;
    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable Long id) {
        return itemsService.getItemById(id).map(item -> new ItemDto(item.getId(),item.getName(),item.getCost())).get();
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemsService.getAllItems().stream().map(item -> new ItemDto(item.getId(),item.getName(),item.getCost())).collect(Collectors.toList());
    }

    @PostMapping
    public void createNewItem(@RequestBody ItemDto itemDto) {
        itemsService.createNewItem(itemDto);
    }
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemsService.deleteItemById(id);
    }
    @DeleteMapping
    public void deleteAll() {
        itemsService.deleteAll();
    }
}
