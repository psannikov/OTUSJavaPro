package ru.otus.pro.psannikov.lru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.pro.psannikov.lru.etities.Cache;

import java.util.Optional;

public interface CacheRepository extends JpaRepository<Cache, Long> {
    void deleteByKey(String cacheKey);
    Cache findByKey(String cacheKey);
}
