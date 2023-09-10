package it.nave.fabrickapitest.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {
  @Id private String transactionId;
  private String operationId;
  private LocalDate accountingDate;
  private LocalDate valueDate;
  @Embedded private TransactionTypeEntity type;
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

  public TransactionTypeEntity getType() {
    return type;
  }

  public void setType(TransactionTypeEntity type) {
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
