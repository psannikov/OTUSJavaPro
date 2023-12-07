package ru.otus.pro.psannikov.lru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.pro.psannikov.lru.etities.Cache;

public interface CacheRepository extends JpaRepository<Cache, Long> {
    Cache findByKey(String cacheKey);
}
