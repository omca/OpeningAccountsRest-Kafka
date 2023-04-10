package com.bank.opening.accounts.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

  private String transactionId;   // ID único de la transacción
  private String accountId;       // ID de la cuenta asociada
  private String transactionType; // Tipo de transacción (DEPOSITO, RETIRO, TRANSFERENCIA)
  private double amount;          // Monto de la transacción
  private String currency;        // Moneda (USD, EUR, etc.)
  private String timestamp;       // Fecha y hora de la transacción
  private String location;        // Ubicación donde ocurrió la transacción
  private String status;          // Estado de la transacción (PENDIENTE, APROBADA, RECHAZADA)
  private boolean isSuspicious;


  }
