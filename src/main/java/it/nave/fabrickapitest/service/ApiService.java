package it.nave.fabrickapitest.service;

import it.nave.fabrickapitest.exchange.ApiExchange;
import it.nave.fabrickapitest.model.Balance;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

  private final ApiExchange apiExchange;

  public ApiService(ApiExchange apiExchange) {
    this.apiExchange = apiExchange;
  }

  public Balance balance(long accountId) {
    return apiExchange.balance(accountId).getPayload();
  }
}
