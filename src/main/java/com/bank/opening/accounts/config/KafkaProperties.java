package com.bank.opening.accounts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.kafka-topics")
public class KafkaProperties {

  private String topicCuentaBancarias;

  public String getTopicCuentaBancarias() {
    return topicCuentaBancarias;
  }

  public void setTopicCuentaBancarias(String topicCuentaBancarias) {
      this.topicCuentaBancarias = topicCuentaBancarias;
  }
}
