package ru.otus.pro.psannikov;

import java.util.List;
import java.util.UUID;

public interface MqPort {

  Message send(String name);

  Message read(UUID id);

  List<Message> readAll();

  void delete(UUID id);

  void save(Message message);
}
