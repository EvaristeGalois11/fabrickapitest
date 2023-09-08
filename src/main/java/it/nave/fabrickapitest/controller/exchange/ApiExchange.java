package it.nave.fabrickapitest.controller.exchange;

import org.springframework.web.service.annotation.GetExchange;

public interface ApiExchange {

  @GetExchange(url = "api/gbs/banking/v4.0/accounts")
  String accounts();
}
