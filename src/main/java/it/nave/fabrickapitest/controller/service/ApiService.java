package it.nave.fabrickapitest.controller.service;

import it.nave.fabrickapitest.controller.exchange.ApiExchange;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

  private final ApiExchange apiExchange;

  public ApiService(ApiExchange apiExchange) {
    this.apiExchange = apiExchange;
  }

  public String accounts() {
    return apiExchange.accounts();
  }
}
