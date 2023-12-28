package ru.otus.pro.psannikov.webapp.controllers;

import ru.otus.pro.psannikov.webapp.models.Microwave;
import ru.otus.pro.psannikov.webapp.services.TimerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timers")
public class TimerController {

    private final TimerService timerService;

    @GetMapping("/state/{id}")
    public ResponseEntity<Microwave> getRemainedTime(@PathVariable String id) {
        return new ResponseEntity<>(timerService.getState(UUID.fromString(id)), HttpStatus.OK);
    }

    @GetMapping("/start/{id}")
    public void startDating(@PathVariable String id) {
        timerService.start(UUID.fromString(id));
    }

}