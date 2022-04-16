package com.taskr.component;

import com.taskr.api.Event;
import com.taskr.api.EventBackbone;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.concurrent.Callable;

public class RabbitMQEventBackbone implements EventBackbone {

  @Value("${rabbitmq.exchange}")
  private String topicExchangeName;
  @Value("${rabbitmq.queue}")
  private String queueName;

  private Object payload;
  private Map<String, Map<String, Object>> metadata;


  @Bean
  public Queue queue() {
    return new Queue(this.queueName, true);
  }

  @Bean
  public TopicExchange exchange() {
    return new TopicExchange(this.topicExchangeName, true, false);
  }


  @Override
  public <T, K extends Map<String, Object>, V> void send(Event<T, K> event, Callable<V> next) {
    try {
      next.call();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public <T, K extends Map<String, Object>, V> Event<T, K> fetch(Callable<V> next) {
    return null;
  }
}
