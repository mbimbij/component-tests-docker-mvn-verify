package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "contact")
@Entity
@Data
@NoArgsConstructor
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;
  private String name;
  private String email;
  private String phoneNumber;
  private String otherValue;
}
