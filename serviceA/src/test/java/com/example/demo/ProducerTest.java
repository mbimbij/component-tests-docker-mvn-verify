package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

//@SpringBootTest(classes = DemoApplication.class)
@Disabled
public class ProducerTest {

  @Autowired
  KafkaTemplate<String,String> producer;

  @Test
  void name() {
    producer.send("test","hello");
  }
}
