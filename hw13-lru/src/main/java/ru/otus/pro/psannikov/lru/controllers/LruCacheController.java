package ru.otus.pro.psannikov.lru.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.pro.psannikov.lru.dtos.CacheDto;
import ru.otus.pro.psannikov.lru.etities.Cache;
import ru.otus.pro.psannikov.lru.service.LruCacheService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cache")
public class LruCacheController {

    private final LruCacheService lruCacheService;

    @PostMapping()
    public void add(@RequestBody Cache cacheItem) {
        lruCacheService.add(cacheItem);
    }

    @GetMapping()
    public Map<String, String> getAll() {
        return lruCacheService.getAll();
    }

    private void deleteByKey(String cacheKey) {
        lruCacheService.deleteByKey(cacheKey);
    }

    public Cache findByKey(String columnName) {
        return lruCacheService.findByKey(columnName);
    }

    @DeleteMapping("/del")
    public void deleteRecord(@RequestBody CacheDto cacheDto) {
        deleteByKey(cacheDto.getCacheKey());
    }
}
