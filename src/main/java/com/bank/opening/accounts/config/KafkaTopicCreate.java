//package com.bank.opening.accounts.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//
///**
// * en esta clase se van a crear los topicos en caso no se hayan creado, si ya están creado no hará nada.
// */
//@Component
//public class KafkaTopicCreate {
//
//  @Bean
//  public NewTopic cuentasBancariasTopic() {
//    return new NewTopic("cuentas-bancarias", 3, (short) 1);
//  }
//
//  @Bean
//  public NewTopic notificacionesCorreosTopic() {
//    return new NewTopic("notificaciones-correos", 3, (short) 1);
//  }
//
//  @Bean
//  public NewTopic fraudeTransaccionesTopic() {
//    return new NewTopic("fraude-transacciones", 3, (short) 1);
//  }
//
//}
