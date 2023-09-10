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
