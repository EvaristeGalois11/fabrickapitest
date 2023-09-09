package it.nave.fabrickapitest.exchange;

import it.nave.fabrickapitest.model.Balance;
import it.nave.fabrickapitest.model.BaseResponse;
import it.nave.fabrickapitest.model.ListHolder;
import it.nave.fabrickapitest.model.Transaction;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface ApiExchange {

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/balance")
  BaseResponse<Balance> balance(@PathVariable long accountId);

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/transactions")
  BaseResponse<ListHolder<Transaction>> transactions(
      @PathVariable long accountId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromAccountingDate,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toAccountingDate);
}
