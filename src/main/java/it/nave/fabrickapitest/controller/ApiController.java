package it.nave.fabrickapitest.controller;

import it.nave.fabrickapitest.model.Balance;
import it.nave.fabrickapitest.model.Transaction;
import it.nave.fabrickapitest.model.TransferRequest;
import it.nave.fabrickapitest.model.TransferResponse;
import it.nave.fabrickapitest.service.ApiService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class ApiController {

  private final ApiService apiService;

  public ApiController(ApiService apiService) {
    this.apiService = apiService;
  }

  @GetMapping(path = "account/{accountId}/balance")
  public Balance getBalance(@PathVariable long accountId) {
    return apiService.balance(accountId);
  }

  @GetMapping(path = "account/{accountId}/transactions")
  public List<Transaction> getTransactions(
      @PathVariable long accountId,
      @RequestParam(defaultValue = "2019-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd")
          LocalDate fromAccountingDate,
      @RequestParam(defaultValue = "2019-12-01") @DateTimeFormat(pattern = "yyyy-MM-dd")
          LocalDate toAccountingDate) {
    return apiService.transactions(accountId, fromAccountingDate, toAccountingDate);
  }

  @PostMapping(path = "account/{accountId}/transfer")
  public TransferResponse createTransfer(
      @PathVariable long accountId, @RequestBody TransferRequest transferRequest) {
    return apiService.transfer(accountId, transferRequest);
  }
}
