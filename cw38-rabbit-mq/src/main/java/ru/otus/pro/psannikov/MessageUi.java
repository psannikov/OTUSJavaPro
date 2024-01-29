package ru.otus.pro.psannikov;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/message")
public interface MessageUi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Message create(@RequestParam String name);

  @GetMapping("/{id}")
  Message readOne(@PathVariable UUID id);

  @GetMapping
  List<Message> readAll();

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void delete(@PathVariable UUID id);

  void consume(Message message);
}