package com.taskr.api;

import com.taskr.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {


  public static Event<Object, Map<String, Object>> event;

  @BeforeAll
  public static void init() {
    User user = User.builder()
            .firstName("Bhavani Chandra")
            .lastName("Vajapeyayajula")
            .email("bhavanichandra9@gmail.com")
            .password("Test@123")
            .build();
    Map<String, Object> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    Map<String, Map<String, Object>> metadata = new HashMap<>();
    metadata.put("headers", headers);
    event = Event.builder()
            .payload(user)
            .metadata(metadata)
            .build();

  }

  @Test
  public void testEvent() {
    assertThat(event).isInstanceOf(Event.class);
    assertThat(event.getPayload()).isInstanceOf(User.class);
  }
}
