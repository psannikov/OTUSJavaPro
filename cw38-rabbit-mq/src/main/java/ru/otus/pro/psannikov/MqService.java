package ru.otus.pro.psannikov;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class MqService implements MqPort {

  private final RabbitTemplate rabbitTemplate;

  private final ConcurrentHashMap<UUID, Message> idToMessage = new ConcurrentHashMap<>();

  @Value("otus.red-key")
  public String firstQueueName;

  public Message send(String name) {
    Message message = createMessage(name);
    rabbitTemplate.convertAndSend(firstQueueName, message);
    return message;
  }

  private Message createMessage(String name) {
    return Message.builder()
        .id(UUID.randomUUID())
        .name(name)
        .build();
  }

  public void save(Message message) {
    idToMessage.put(message.getId(), message);
  }

  public Message read(UUID id) {
    return idToMessage.get(id);
  }

  public List<Message> readAll() {
    return idToMessage.values().stream().toList();
  }

  public void delete(UUID id) {
    idToMessage.remove(id);
  }
}
