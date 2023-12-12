package ru.otus.pro.psannikov.lru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.pro.psannikov.lru.dtos.CacheDto;
import ru.otus.pro.psannikov.lru.etities.Cache;
import ru.otus.pro.psannikov.lru.repositories.CacheRepository;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LruCacheService {
    private final int capacity;
    private final Map<String, String> cache;
    private final CacheRepository cacheRepository;

    @Autowired
    public LruCacheService(CacheRepository cacheRepository, @Value("${lru.capacity}") int capacity) {
        this.cacheRepository = cacheRepository;
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
        Iterable<Cache> cacheItems = cacheRepository.findAll();
        cacheItems.forEach(item -> cache.put(item.getKey(), item.getCacheValue()));
    }

    public void add(Cache cacheItem) {
        if (cache.containsKey(cacheItem.getKey())) {
            return;
        }
        if (cache.size() == capacity) {
            String oldestKey = (cache.keySet().iterator().hasNext()) ? cache.keySet().iterator().next() : null;
            deleteByKey(oldestKey);
        }
        cache.put(cacheItem.getKey(), cacheItem.getCacheValue());
        cacheRepository.save(cacheItem);
    }

    public Map<String, String> getAll() {
        return cache;
    }

    public void deleteByKey(String cacheKey) {
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
