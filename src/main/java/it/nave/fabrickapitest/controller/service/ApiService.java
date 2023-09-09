package it.nave.fabrickapitest.controller.service;

import it.nave.fabrickapitest.controller.exchange.ApiExchange;
import it.nave.fabrickapitest.controller.model.*;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

  private final ApiExchange apiExchange;

  public ApiService(ApiExchange apiExchange) {
    this.apiExchange = apiExchange;
  }

  public AccountsResponse accounts() {
    return apiExchange.accounts();
  }

  public AccountResponse account(long accountId) {
    return apiExchange.account(accountId);
  }

  public Balance balance(long accountId) {
    return apiExchange.balance(accountId).getPayload();
  }
}
