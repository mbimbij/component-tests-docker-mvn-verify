package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
@SpringBootTest
@Disabled
class ServiceATestcontainers {
  @Container
  private static DockerComposeContainer infra =
      new DockerComposeContainer(new File("src/test/resources/docker-compose-component-test.yml"))
          .waitingFor("database_1", Wait.forLogMessage(".*ready for connections.*", 1));
  @Autowired
  private ContactRepository contactRepository;

  @Test
  void contextLoads() {
    System.out.println("coucou TU");
    Contact contact = new Contact();
    contact.setName("joseph");
    contactRepository.save(contact);
    contactRepository.findAll().forEach(System.out::println);
  }

}
