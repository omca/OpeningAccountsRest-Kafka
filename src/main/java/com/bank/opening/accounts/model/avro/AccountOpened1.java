//package com.bank.opening.accounts.model.avro;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.apache.avro.Schema;
//import org.apache.avro.SchemaBuilder;
//import org.apache.avro.specific.SpecificRecordBase;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class AccountOpened extends SpecificRecordBase {
//
//  private String accountId;
//  private String accountHolder;
//  private String accountType;
//  private double balance;
//  private String dateOpened;
//
//  public static final Schema SCHEMA$ = SchemaBuilder.record("AccountOpened")
//    .namespace("com.bank.opening.accounts.model.avro")
//    .fields()
//    .name("accountId").type().stringType().noDefault()
//    .name("accountHolder").type().stringType().noDefault()
//    .name("accountType").type().stringType().noDefault()
//    .name("balance").type().doubleType().noDefault()
//    .name("dateOpened").type().stringType().noDefault()
//    .endRecord();
//
//  @Override
//  public Schema getSchema() {
//    return SCHEMA$;
//  }
//
//  @Override
//  public Object get(int field) {
//    return switch (field) {
//      case 0 -> accountId;
//      case 1 -> accountHolder;
//      case 2 -> accountType;
//      case 3 -> balance;
//      case 4 -> dateOpened;
//      default -> throw new IllegalArgumentException("Unknown field index " + field);
//    };
//  }
//
//  @Override
//  public void put(int field, Object value) {
//    switch (field) {
//      case 0: accountId = value.toString(); break;
//      case 1: accountHolder = value.toString(); break;
//      case 2: accountType = value.toString(); break;
//      case 3: balance = (double) value; break;
//      case 4: dateOpened = value.toString(); break;
//      default: throw new IllegalArgumentException("Unknown field index " + field);
//    }
//  }
//}
