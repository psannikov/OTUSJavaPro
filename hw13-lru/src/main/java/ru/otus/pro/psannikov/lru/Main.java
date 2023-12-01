package ru.otus.pro.psannikov.lru;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        PersistentLruCache persistentLruCache = new PersistentLruCache<>(1000, "lru_cache");
        System.out.println(persistentLruCache.getAllLruCacheKeys());
        for (int i = 0; i <= 500; i++) {
            persistentLruCache.add("Key " + generateRandomNumber(1, 1000), new Object());
        }
        System.out.println(persistentLruCache.getAllLruCacheKeys());
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
