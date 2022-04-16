package com.taskr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskrController {

  @GetMapping(path = "/ping")
  public String healthCheck() {
    return "Hello World!";
  }
}
