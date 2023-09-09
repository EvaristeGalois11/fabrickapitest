package it.nave.fabrickapitest.service;

import it.nave.fabrickapitest.exception.ApiException;
import it.nave.fabrickapitest.exchange.ApiExchange;
import it.nave.fabrickapitest.mapper.TransferMapper;
import it.nave.fabrickapitest.model.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class ApiService {

  private final ApiExchange apiExchange;
  private final TransferMapper transferMapper;

  public ApiService(ApiExchange apiExchange, TransferMapper transferMapper) {
    this.apiExchange = apiExchange;
    this.transferMapper = transferMapper;
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
    var apiRequest = transferMapper.toApi(transferRequest);
    try {
      return apiExchange.transfer(accountId, apiRequest).getPayload();
    } catch (HttpStatusCodeException e) {
      throw new ApiException(
          "API000",
          "Errore tecnico La condizione BP049 non e' prevista per il conto id " + accountId,
          e);
    }
  }
}
