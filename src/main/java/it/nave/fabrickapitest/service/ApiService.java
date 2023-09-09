package it.nave.fabrickapitest.service;

import it.nave.fabrickapitest.exchange.ApiExchange;
import it.nave.fabrickapitest.model.*;
import java.time.LocalDate;
import java.util.List;
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

  public List<Transaction> transactions(
      long accountId, LocalDate fromAccountingDate, LocalDate toAccountingDate) {
    return apiExchange
        .transactions(accountId, fromAccountingDate, toAccountingDate)
        .getPayload()
        .getList();
  }

  public TransferResponse transfer(long accountId, TransferRequest transferRequest) {
    var creditor = new Creditor();
    creditor.setName(transferRequest.getReceiverName());
    var request = new TransferRequestApi();
    request.setCreditor(creditor);
    request.setDescription(transferRequest.getDescription());
    request.setCurrency(transferRequest.getCurrency());
    request.setAmount(transferRequest.getAmount());
    request.setExecutionDate(transferRequest.getExecutionDate());
    return apiExchange.transfer(accountId, request).getPayload();
  }
}
