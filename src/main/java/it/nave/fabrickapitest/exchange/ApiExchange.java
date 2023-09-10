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
package it.nave.fabrickapitest.exchange;

import it.nave.fabrickapitest.model.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface ApiExchange {

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/balance")
  BaseResponse<Balance> balance(@PathVariable long accountId);

  @GetExchange(url = "api/gbs/banking/v4.0/accounts/{accountId}/transactions")
  ListResponse<Transaction> transactions(
      @PathVariable long accountId,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromAccountingDate,
      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toAccountingDate);

  @PostExchange(url = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers")
  BaseResponse<TransferResponse> transfer(
      @PathVariable long accountId, @RequestBody TransferRequestApi transferRequestApi);
}
