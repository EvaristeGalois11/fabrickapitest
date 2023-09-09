package it.nave.fabrickapitest.controller;

import it.nave.fabrickapitest.model.Balance;
import it.nave.fabrickapitest.model.Transaction;
import it.nave.fabrickapitest.service.ApiService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "account")
public class AccountController {

  private final ApiService apiService;

  public AccountController(ApiService apiService) {
    this.apiService = apiService;
  }

  @GetMapping(path = "{accountId}/balance")
  public Balance getBalance(@PathVariable long accountId) {
    return apiService.balance(accountId);
  }

  @GetMapping(path = "{accountId}/transactions")
  public List<Transaction> getBalance(
      @PathVariable long accountId,
      @RequestParam(defaultValue = "2019-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd")
          LocalDate fromAccountingDate,
      @RequestParam(defaultValue = "2019-12-01") @DateTimeFormat(pattern = "yyyy-MM-dd")
          LocalDate toAccountingDate) {
    return apiService.transactions(accountId, fromAccountingDate, toAccountingDate);
  }
}
