package com.taskr.model;

import lombok.Builder;
import lombok.Data;
//import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;
  @Column(name = "email")
  private String email;
  @Column(name = "password")
  private String password;

}
