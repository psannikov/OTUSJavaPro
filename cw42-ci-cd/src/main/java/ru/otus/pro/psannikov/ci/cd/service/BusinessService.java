package ru.otus.pro.psannikov.ci.cd.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BusinessService {
    private final Set<Long> storage = ConcurrentHashMap.newKeySet();

    public void add(Long value) {
        storage.add(value);
    }

    public void remove(Long value) {
        storage.remove(value);
    }

    public Set<Long> list() {
        return storage;
    }
}
