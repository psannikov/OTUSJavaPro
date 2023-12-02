package ru.otus.pro.psannikov.lru.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.lru.dtos.CacheDto;
import ru.otus.pro.psannikov.lru.etities.Cache;
import ru.otus.pro.psannikov.lru.repositories.CacheRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cache")
public class LruCacheController {
    private final int capacity;
    private final Map<String, String> cache;
    private final CacheRepository cacheRepository;

    @Autowired
    public LruCacheController(CacheRepository cacheRepository, @Value("${lru.capacity}") int capacity) {
        this.cacheRepository = cacheRepository;
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
        Iterable<Cache> cacheItems = cacheRepository.findAll();
        cacheItems.forEach(item -> cache.put(item.getKey(), item.getCacheValue()));
    }

    @PostMapping()
    public void add(@RequestBody Cache cacheItem) {
        if (cache.containsKey(cacheItem.getKey())) {
            return;
        }
        if (cache.size() == capacity) {
            String oldestKey = cache.keySet().iterator().next();
            deleteByKey(oldestKey);
        }
        cache.put(cacheItem.getKey(),cacheItem.getCacheValue());
        cacheRepository.save(cacheItem);
    }

    @GetMapping()
    public Map<String, String> getAll() {
        return cache;
    }

    private void deleteByKey(String cacheKey) {
        if (cache.containsKey(cacheKey)) {
            cache.remove(cacheKey);
            Cache cacheRepositoryItem = findByKey(cacheKey);
            cacheRepository.deleteById(cacheRepositoryItem.getId());
        }
    }
    public Cache findByKey(String columnName) {
        return cacheRepository.findByKey(columnName);
    }
    @DeleteMapping("/del")
    public void deleteRecord(@RequestBody CacheDto cacheDto) {
        deleteByKey(cacheDto.getCacheKey());
    }
}
