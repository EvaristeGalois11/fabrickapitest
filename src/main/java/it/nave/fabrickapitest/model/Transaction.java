package it.nave.fabrickapitest.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
  private String transactionId;
  private String operationId;
  private LocalDate accountingDate;
  private LocalDate valueDate;
  private TransactionType type;
  private BigDecimal amount;
  private String currency;
  private String description;

  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }

  public String getOperationId() {
    return operationId;
  }

  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  public LocalDate getAccountingDate() {
    return accountingDate;
  }

  public void setAccountingDate(LocalDate accountingDate) {
    this.accountingDate = accountingDate;
  }

  public LocalDate getValueDate() {
    return valueDate;
  }

  public void setValueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
  }

  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
