package ru.otus.pro.psannikov.spring.boot.part2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.spring.boot.part2.dtos.ItemDto;
import ru.otus.pro.psannikov.spring.boot.part2.entities.Item;
import ru.otus.pro.psannikov.spring.boot.part2.exceptions.ErrorDto;
import ru.otus.pro.psannikov.spring.boot.part2.exceptions.ResourceNotFoundException;
import ru.otus.pro.psannikov.spring.boot.part2.repositories.ItemsRepository;
import ru.otus.pro.psannikov.spring.boot.part2.services.ItemsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemsControllers {
    private final ItemsService itemsService;
    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable Long id) {
        return itemsService.getItemById(id).map(item -> new ItemDto(item.getId(),item.getName(),item.getCost())).orElseThrow(() -> new ResourceNotFoundException("Указанный продукт не найден"));
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
