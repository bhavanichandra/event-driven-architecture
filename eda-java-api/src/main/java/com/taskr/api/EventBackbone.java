package com.taskr.api;


import java.util.Map;
import java.util.concurrent.Callable;

/**
 * EventBackbone provides an interface to communicate with any event backbone systems such as
 * RabbitMQ or Kafka or any other
 *
 * @author Bhavani Chandra
 * @license MIT
 */
public interface EventBackbone {


  /**
   * @param event is any event
   * @param next  is a Callable functional interface
   * @param <T>   the type of payload
   * @param <K>   the type of metadata that extends Map<String,Object></String,Object
   */
  <T, K extends Map<String, Object>, V> void send(Event<T, K> event, Callable<V> next);

  /**
   * @param next is a Callable functional interface
   * @param <T>  the type of payload
   * @param <K>  the type of metadata that extends Map<String,Object></String,Object
   * @param <V>  Callable next method
   * @return the event
   */
  <T, K extends Map<String, Object>, V> Event<T, K> fetch(Callable<V> next);

}
