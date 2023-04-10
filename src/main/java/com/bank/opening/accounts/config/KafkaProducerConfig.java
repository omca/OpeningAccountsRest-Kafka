package com.bank.opening.accounts.config;

import com.bank.opening.accounts.model.avro.AccountOpened;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuracion del productor de mensajes de Kafka
 */
@Configuration
public class KafkaProducerConfig {

  /**
   * Crea un Bean para Factory de Producer
   * @return
   */
  @Bean
  public ProducerFactory<String, Object> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // broker
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // key serializaer para el avro
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class); // value serializer para el avro
    configProps.put("schema.registry.url", "http://localhost:8084"); // url para el schema registry para el avro
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  /**
   * Kafkatemplate es el objeto que se usará para enviar mensajes a kafka
   * En la creacion de la instancia recibe toda la info de un ProducerFactory<String, AccountOpened>
   * @return
   */
  @Bean
  public KafkaTemplate<String, Object> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}


