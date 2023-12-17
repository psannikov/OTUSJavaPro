package ru.otus.pro.psannikov.spring.boot.part1.diff;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.otus.pro.psannikov.spring.boot.part1.entities.Item;

import java.util.List;
@Component
public class ItemsInMemoryRepository {
    private List<Item> items;
    @PostConstruct
    public void init() {
        this.items = List.of(new Item(1L, "Item #" + 1, 100),
                new Item(2L, "Item #" + 2, 100),
                new Item(3L, "Item #" + 3, 100),
                new Item(4L, "Item #" + 4, 100));
    }

    public Item getItemById (Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public List<Item> getAllItems() {
        return items;
    }
}
