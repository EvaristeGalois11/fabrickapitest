package it.nave.fabrickapitest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferRequestApi {
  private Creditor creditor;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate executionDate;

  private String uri;
  private String description;
  private BigDecimal amount;
  private String currency;

  @JsonProperty("isUrgent")
  private boolean urgent;

  @JsonProperty("isInstant")
  private boolean instant;

  public Creditor getCreditor() {
    return creditor;
  }

  public void setCreditor(Creditor creditor) {
    this.creditor = creditor;
  }

  public LocalDate getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(LocalDate executionDate) {
    this.executionDate = executionDate;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public boolean isInstant() {
    return instant;
  }

  public void setInstant(boolean instant) {
    this.instant = instant;
  }
}
