package it.nave.fabrickapitest.controller.exchange;

import it.nave.fabrickapitest.controller.model.AccountResponse;
import it.nave.fabrickapitest.controller.model.AccountsResponse;
import it.nave.fabrickapitest.controller.model.Balance;
import it.nave.fabrickapitest.controller.model.BaseResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ApiExchange {

  @GetExchange(url = "api/gbs/banking/v4.0/accounts")
  AccountsResponse accounts();

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}")
  AccountResponse account(@PathVariable long accountId);

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/balance")
  BaseResponse<Balance> balance(@PathVariable long accountId);
}
