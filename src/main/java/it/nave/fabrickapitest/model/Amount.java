package it.nave.fabrickapitest.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Amount {
  private BigDecimal debtorAmount;
  private String debtorCurrency;
  private BigDecimal creditorAmount;
  private String creditorCurrency;
  private LocalDate creditorCurrencyDate;
  private BigDecimal exchangeRate;

  public BigDecimal getDebtorAmount() {
    return debtorAmount;
  }

  public void setDebtorAmount(BigDecimal debtorAmount) {
    this.debtorAmount = debtorAmount;
  }

  public String getDebtorCurrency() {
    return debtorCurrency;
  }

  public void setDebtorCurrency(String debtorCurrency) {
    this.debtorCurrency = debtorCurrency;
  }

  public BigDecimal getCreditorAmount() {
    return creditorAmount;
  }

  public void setCreditorAmount(BigDecimal creditorAmount) {
    this.creditorAmount = creditorAmount;
  }

  public String getCreditorCurrency() {
    return creditorCurrency;
  }

  public void setCreditorCurrency(String creditorCurrency) {
    this.creditorCurrency = creditorCurrency;
  }

  public LocalDate getCreditorCurrencyDate() {
    return creditorCurrencyDate;
  }

  public void setCreditorCurrencyDate(LocalDate creditorCurrencyDate) {
    this.creditorCurrencyDate = creditorCurrencyDate;
  }

  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }
}
