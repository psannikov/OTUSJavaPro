package ru.otus.pro.psannikov.lru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.pro.psannikov.lru.entities.LruCache;

public interface CacheRepository extends JpaRepository<LruCache, String> {

    void deleteByKey(String key);
}
