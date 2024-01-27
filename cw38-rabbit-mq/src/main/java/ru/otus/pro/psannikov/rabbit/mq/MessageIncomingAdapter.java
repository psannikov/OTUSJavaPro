package ru.otus.pro.psannikov.rabbit.mq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageIncomingAdapter implements MessageUi {

    private final MqPort mqService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message create(@RequestParam String name) {
        return mqService.send(name);
    }

    @Override
    public Message readOne(UUID id) {
        return mqService.read(id);
    }

    @Override
    public List<Message> readAll() {
        return mqService.readAll();
    }

    @Override
    public void delete(UUID id) {
        mqService.delete(id);
    }

//  @RabbitListener(queues = "${ru.otus.pro.psannikov.rabbit.mq.first-queue-name}")
//  public void consume(Message message) {
//    mqService.save(message);
//  }
}