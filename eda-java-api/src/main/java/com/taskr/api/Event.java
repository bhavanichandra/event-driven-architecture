package com.taskr.api;

import lombok.Builder;
import lombok.Data;

import java.util.Map;


/**
 * Event is a class which helps to model messages / events from the Event backbone
 *
 * @param <T> the type of payload
 * @param <K> the type of metadata that extends Map<String,Object></String,Object>
 * @author Bhavani Chandra
 * @license MIT
 */
@Data
@Builder
public class Event<T, K extends Map<String, Object>> {
  private final T payload;
  private final Map<String, K> metadata;


  /**
   * @param key is the metadata key. ex: headers or method
   * @return The metadata value for that key
   */
  public K getMetadataByKey(String key) {
    return this.metadata.getOrDefault(key, null);
  }

  /**
   *
   * @param key is the key to be removed from the metadata
   * @return The metadata
   */
  public Map<String, K> removeMetadataEntry(String key) {
    this.metadata.remove(key);
    return this.metadata;
  }

}
