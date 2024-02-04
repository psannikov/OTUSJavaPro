package ru.otus.pro.psannikov;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfiguration {

  @Value("otus.red-key")
  public String firstQueueName;

  @Value("red-queue")
  public String bindingKey;

  @Value("otus.red-key")
  public String routingKey;

  @Bean
  public Queue firstQueue() {
    return new Queue(firstQueueName, false);
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange(bindingKey);
  }

  @Bean
  Binding binding(Queue queue) {
    return BindingBuilder.bind(queue).to(exchange()).with(routingKey);
  }

  @Bean
  public Jackson2JsonMessageConverter jsonConverter(ObjectMapper objectMapper) {
    return new Jackson2JsonMessageConverter(objectMapper);
  }

  @Bean
  RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter,
      CachingConnectionFactory connectionFactory) {

    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(converter);
    return template;
  }
}
