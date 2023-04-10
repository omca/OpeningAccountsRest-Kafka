//package com.bank.opening.accounts.service;
//
//import com.bank.opening.accounts.model.avro.NotificationEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//  private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
//  @Autowired
//  public NotificationService(KafkaTemplate<String, NotificationEvent> kafkaTemplate) {
//    this.kafkaTemplate = kafkaTemplate;
//  }
//
//  public void sendNotification(String email, String message) {
//    NotificationEvent notificationEvent = new NotificationEvent();
//    notificationEvent.setEmail(email);
//    notificationEvent.setMessage(message);
//    kafkaTemplate.send("notificaciones-correos", email, notificationEvent);
//  }
//}
