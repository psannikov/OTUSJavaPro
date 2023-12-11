package ru.otus.pro.psannikov.webapp.models;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Data
@Slf4j
@Scope("prototype")
public class TimerDto implements Runnable {

    private UUID microwaveId;
    private int seconds;
    private boolean finished;
    private Microwave microwave;

    public TimerDto(int seconds, UUID microwaveId, Microwave microwave) {
        this.seconds = seconds;
        this.microwaveId = microwaveId;
        this.microwave = microwave;
        run();
    }

    @Override
    public void run() {
        ThreadLocal<Integer> time = new ThreadLocal<>();
        time.set(seconds);
        microwave.setSeconds(seconds);
        log.info("Microwave {} has been started!", microwaveId);
        while (!finished) {
            log.info("Time remained: {} for Microwave - {}", seconds, microwaveId);
            time.set(seconds--);
            TimerStorage.timerObjects.computeIfPresent(
                    microwaveId, (key, oldValue) -> new Microwave(time.get())
            );
            if (time.get() == 1) {
                finished = true;
                destroyTimer(microwaveId);
                log.info("Time's up for Microwave - {}", this.microwaveId);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                log.error("Error! Something went wrong! Microwave {} was interrupted!", microwaveId);
            }
        }
    }

    private void destroyTimer(UUID uuid) {
        log.info("Microwave {} has been destroyed!", uuid);
        TimerStorage.timerObjects.remove(uuid);
    }

}