/*
 *Copyright (C) 2023 Claudio Nave
 *
 *This file is part of fabrickapitest.
 *
 *fabrickapitest is free software: you can redistribute it and/or modify
 *it under the terms of the GNU General Public License as published by
 *the Free Software Foundation, either version 3 of the License, or
 *(at your option) any later version.
 *
 *fabrickapitest is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with fabrickapitest. If not, see <https://www.gnu.org/licenses/>.
 */
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
  private final TransactionService transactionService;

  public ApiService(
      ApiExchange apiExchange,
      TransferMapper transferMapper,
      TransactionService transactionService) {
    this.apiExchange = apiExchange;
    this.transferMapper = transferMapper;
    this.transactionService = transactionService;
  }

  public Balance balance(long accountId) {
    return apiExchange.balance(accountId).getPayload();
  }

  public List<Transaction> transactions(
      long accountId, LocalDate fromAccountingDate, LocalDate toAccountingDate) {
    var transactions =
        apiExchange
            .transactions(accountId, fromAccountingDate, toAccountingDate)
            .getPayload()
            .getList();
    transactionService.storeTransaction(transactions);
    return transactions;
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
