package ru.otus.pro.psannikov.cache.engine.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakCacheImpl<K, V> implements WeakCache<K, V> {
    private final Map<K, V> cache = new WeakHashMap<>();

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }
}