package ru.otus.pro.psannikov.lru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.pro.psannikov.lru.entities.LruCache;
import ru.otus.pro.psannikov.lru.repositories.CacheRepository;

import java.util.*;

@Service
public class LruCacheService<String, Object> {
    private final int capacity;
    private final Map<String, Object> map;
    private final CacheRepository cacheRepository;
    @Autowired
    public LruCacheService(CacheRepository cacheRepository, @Value("${lru.capacity}") int capacity) {
        this.capacity = capacity;
        this.cacheRepository = cacheRepository;
        map = new LinkedHashMap<>(capacity);
    }
    public boolean exists(String key) {
        return map.containsKey(key);
    }
    public Object get(String key) {
        if (exists(key)) {
            Object value = map.remove(key);
            map.put(key, value);
            return value;
        }

        throw new NoSuchElementException();
    }

    public void add(String key, Object value) {
        if (exists(key))
            map.put(key, value);
        else {
            if (map.size() == capacity) {
                String removedKey = map.keySet().iterator().next();
                cacheRepository.deleteByKey((java.lang.String) removedKey);
                map.remove(removedKey);
            }

            map.put(key, value);
            cacheRepository.save(new LruCache((java.lang.String) key, value));
        }
    }

    public List<String> getAllKeys() {
        return new ArrayList<>(map.keySet());
    }
}
