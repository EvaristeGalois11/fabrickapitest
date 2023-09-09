package it.nave.fabrickapitest.exchange;

import it.nave.fabrickapitest.model.Balance;
import it.nave.fabrickapitest.model.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ApiExchange {

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/balance")
  BaseResponse<Balance> balance(@PathVariable long accountId);
}
