package ru.otus.pro.psannikov.lru;

import java.io.*;
import java.util.*;

public class PersistentLruCache<K, V> {

    private final int capacity;
    private final Map<K, V> map;
    private final String filePath;

    public PersistentLruCache(int capacity, String filePath) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
        this.filePath = filePath;
        loadFromFile();
    }

    public boolean exists(K key) {
        return map.containsKey(key);
    }

    public V get(K key) {
        if (exists(key)) {
            V value = map.remove(key);
            map.put(key, value);
            return value;
        }

        throw new NoSuchElementException();
    }

    public void add(K key, V value) {
        if (exists(key))
            map.put(key, value);
        else {
            if (map.size() == capacity)
                evictOldestEntry();

            map.put(key, value);
        }
        saveToFile();
    }

    private void evictOldestEntry() {
        K oldestKey = map.keySet().iterator().next();
        map.remove(oldestKey);
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(filePath);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();
                if (obj instanceof Map) {
                    map.clear();
                    map.putAll((Map<K, V>) obj);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // Create an empty cache if the file does not exist
            saveToFile();
        }
    }

    public List<?> getAllLruCacheKeys() {
        return new ArrayList<>(map.keySet());
    }
}

