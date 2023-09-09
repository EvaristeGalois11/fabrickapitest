package it.nave.fabrickapitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferResponse {
  private String moneyTransferId;
  private String status;
  private String direction;
  private Creditor creditor;
  private String description;
  private Amount amount;

  @JsonProperty("isUrgent")
  private boolean isUrgent;

  @JsonProperty("isInstant")
  private boolean isInstant;

  public String getMoneyTransferId() {
    return moneyTransferId;
  }

  public void setMoneyTransferId(String moneyTransferId) {
    this.moneyTransferId = moneyTransferId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public Creditor getCreditor() {
    return creditor;
  }

  public void setCreditor(Creditor creditor) {
    this.creditor = creditor;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setUrgent(boolean urgent) {
    isUrgent = urgent;
  }

  public boolean isInstant() {
    return isInstant;
  }

  public void setInstant(boolean instant) {
    isInstant = instant;
  }
}
