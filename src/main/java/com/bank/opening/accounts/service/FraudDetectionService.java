//package com.bank.opening.accounts.service;
//
//import com.bank.opening.accounts.model.Transaction;
//import com.bank.opening.accounts.model.avro.FraudAlert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FraudDetectionService {
//  private final KafkaTemplate<String, FraudAlert> kafkaTemplate;
//
//  @Autowired
//  public FraudDetectionService(KafkaTemplate<String, FraudAlert> kafkaTemplate) {
//    this.kafkaTemplate = kafkaTemplate;
//  }
//
//  public void checkTransaction(Transaction transaction) {
//    if (transaction.isSuspicious()) {
//      FraudAlert fraudAlert = new FraudAlert();
//      fraudAlert.setAlertType("roja");
//        kafkaTemplate.send("fraude-transacciones", transaction.getAccountId(), fraudAlert);
//    }
//  }
//}
