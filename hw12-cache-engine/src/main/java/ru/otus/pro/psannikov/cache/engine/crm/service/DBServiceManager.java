package ru.otus.pro.psannikov.cache.engine.crm.service;

import ru.otus.pro.psannikov.cache.engine.crm.model.Manager;

import java.util.List;
import java.util.Optional;

public interface DBServiceManager {

    Manager saveManager(Manager client);

    Optional<Manager> getManager(long no);

    List<Manager> findAll();
}
