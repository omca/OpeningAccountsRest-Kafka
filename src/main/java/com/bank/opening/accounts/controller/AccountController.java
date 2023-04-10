package com.bank.opening.accounts.controller;

import com.bank.opening.accounts.model.Account;
import com.bank.opening.accounts.service.AccountService;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

  private final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/")
  public Single<ResponseEntity<Account>> createAccount(@RequestBody Account account) {
    return accountService.createAccount(account)
      .map(savedAccount -> ResponseEntity.status(HttpStatus.CREATED)
        .header("custom-header", "param112345678")
        .body(account))
      .onErrorReturn(throwable -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  
}
