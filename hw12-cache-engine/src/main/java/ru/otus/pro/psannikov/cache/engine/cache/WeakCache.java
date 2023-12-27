package ru.otus.pro.psannikov.cache.engine.cache;

public interface WeakCache<K, V> {
    public V get(K key);
    public void put(K key, V value);
    public void remove(K key);
    public void clear();
    public int size();
}
