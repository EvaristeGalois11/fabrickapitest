/*
 *Copyright (C) 2023 Claudio Nave
 *
 *This file is part of fabrickapitest.
 *
 *fabrickapitest is free software: you can redistribute it and/or modify
 *it under the terms of the GNU General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *fabrickapitest is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with fabrickapitest. If not, see <https://www.gnu.org/licenses/>.
 */
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
