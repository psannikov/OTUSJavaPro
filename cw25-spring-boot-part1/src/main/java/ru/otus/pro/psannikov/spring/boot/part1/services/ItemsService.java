package ru.otus.pro.psannikov.spring.boot.part1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.spring.boot.part1.dtos.ItemDto;
import ru.otus.pro.psannikov.spring.boot.part1.entities.Item;
import ru.otus.pro.psannikov.spring.boot.part1.repositories.ItemsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemsService {
    private final ItemsRepository itemsRepository;

    public Optional<Item> getItemById(Long id) {
        return itemsRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemsRepository.findAll();
    }

    public void createNewItem(ItemDto itemDto) {
        Item item = new Item(itemDto.getId(), itemDto.getName(), itemDto.getCost());
        itemsRepository.save(item);
    }

    public void deleteItemById(Long id) {
        itemsRepository.deleteById(id);
    }

    public void deleteAll() {
        itemsRepository.deleteAll();
    }
}
