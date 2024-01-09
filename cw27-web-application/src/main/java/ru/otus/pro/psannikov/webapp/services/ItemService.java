package ru.otus.pro.psannikov.webapp.services;

import ru.otus.pro.psannikov.webapp.models.Item;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {

    private final Map<Integer, Item> items = new HashMap<>() {{
        put(1, new Item(1,"item1"));
        put(2, new Item(2,"item2"));
        put(3, new Item(3,"item3"));
        put(4, new Item(4,"item4"));
        put(5, new Item(5,"item5"));

    }};

    public Collection<Item> getAll() {
        return items.values();
    }

    public Item getOne(Integer id) {
        return items.get(id);
    }

    public Item createOne(String name) {
        int mapSize = items.size();
        Item item = new Item(mapSize, name);
        items.put(mapSize + 1, item);
        return item;
    }

    public String deleteOne(Integer id) {
        if (items.containsKey(id)) {
            items.remove(id);
            return "Item with id " + id + "has been removed!";
        } else {
            return "No item with id " + id + " presents!";
        }
    }

    public String updateOne(Integer id, String name) {
        if (items.containsKey(id)) {
            items.remove(id);
            items.put(id, new Item(id, name));
            return "An item with id " + id + " has been updated!";
        } else {
            return "No item with id " + id + " presents!";
        }
    }

}