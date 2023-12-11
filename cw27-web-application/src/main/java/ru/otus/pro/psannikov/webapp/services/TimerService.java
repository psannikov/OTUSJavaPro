package ru.otus.pro.psannikov.webapp.services;

import ru.otus.pro.psannikov.webapp.models.Microwave;
import ru.otus.pro.psannikov.webapp.models.TimerDto;
import ru.otus.pro.psannikov.webapp.models.TimerStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class TimerService {

    public Microwave getState(UUID uuid) {
        return TimerStorage.timerObjects.get(uuid);
    }

    @Async
    public void start(UUID id) {

        Microwave microwave = TimerStorage.timerObjects.get(id);

        if (microwave == null) {
            microwave = new Microwave(30);
            TimerStorage.timerObjects.put(id, microwave);
            new TimerDto(30, id, microwave);
        } else {
            log.info("Timer for Microwave {} has been already started!", id);
        }
    }

}