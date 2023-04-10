package com.bank.opening.accounts.service;

import com.bank.opening.accounts.config.KafkaProperties;
import com.bank.opening.accounts.model.Account;
import com.bank.opening.accounts.model.avro.AccountOpened;
import com.bank.opening.accounts.repository.AccountRepository;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

  private final AccountRepository repository;

  private final KafkaTemplate<String, Object> kafkaTemplate;

  private final KafkaProperties kafkaProperties;

  @Autowired
  public AccountService(AccountRepository repository,
    KafkaTemplate<String, Object> kafkaTemplate,
                      KafkaProperties kafkaProperties) {
    this.repository = repository;
    this.kafkaTemplate = kafkaTemplate;
    this.kafkaProperties = kafkaProperties;
  }

  public Single<Account> createAccount(Account account) {
    return Single.fromCallable(() -> {
      Account objAccount = repository.save(account);
      AccountOpened avroAccount = new AccountOpened();
      avroAccount.setAccountId(objAccount.getId().toString());
      avroAccount.setAccountHolder(objAccount.getHolderName());
      avroAccount.setAccountType(objAccount.getAccountType());
      avroAccount.setBalance(objAccount.getBalance());
      avroAccount.setDateOpened(LocalDateTime.now().toString());

      for (int x = 0; x < 100; x++) {

      //   public ProducerRecord(String topic, Integer partition, K key, V value) {
      // pueden haber algunos eventos que se envíen a partitions especificas
        kafkaTemplate.send(new ProducerRecord<>(
          kafkaProperties.getTopicCuentaBancarias(),
//          avroAccount.getAccountId().toString(),
          String.valueOf(x),
          avroAccount)
        );
      }
      kafkaTemplate.flush();
      return objAccount;
    }).subscribeOn(Schedulers.io());
  }
}
