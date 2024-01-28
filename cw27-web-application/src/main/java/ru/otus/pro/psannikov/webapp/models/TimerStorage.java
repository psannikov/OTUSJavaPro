package ru.otus.pro.psannikov.webapp.models;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TimerStorage {
    public static Map<UUID, Microwave> timerObjects = new ConcurrentHashMap<>();
}