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
package it.nave.fabrickapitest;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.okForJson;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import it.nave.fabrickapitest.model.*;
import it.nave.fabrickapitest.model.Error;
import java.util.List;
import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

abstract class FabrickApiTestIT {
  @Autowired private TestRestTemplate rest;

  @RegisterExtension
  static WireMockExtension wireMockExtension =
      WireMockExtension.newInstance()
          .options(wireMockConfig().dynamicPort())
          .configureStaticDsl(true)
          .build();

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("fabrick.api.base-url", wireMockExtension::baseUrl);
  }

  @ParameterizedTest
  @InstancioSource
  void getBalanceTest(long accountId, BaseResponse<Balance> apiResponse) {
    stubFor(
        get(urlPathTemplate("/api/gbs/banking/v4.0/accounts/{accountId}/balance"))
            .withPathParam("accountId", equalTo(Long.toString(accountId)))
            .withHeader("Auth-Schema", equalTo("S2S"))
            .withHeader("Api-Key", equalTo("FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP"))
            .withHeader("X-Time-Zone", equalTo("Europe/Rome"))
            .willReturn(okForJson(apiResponse)));
    var response = rest.getForEntity("/api/account/{accountId}/balance", Balance.class, accountId);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).usingRecursiveComparison().isEqualTo(apiResponse.getPayload());
  }

  @ParameterizedTest
  @InstancioSource
  void getTransactionsTest(long accountId, ListResponse<Transaction> apiResponse) {
    stubFor(
        get(urlPathEqualTo("/api/gbs/banking/v4.0/accounts/" + accountId + "/transactions"))
            .withQueryParam("fromAccountingDate", equalTo("2019-01-01"))
            .withQueryParam("toAccountingDate", equalTo("2019-12-01"))
            .withHeader("Auth-Schema", equalTo("S2S"))
            .withHeader("Api-Key", equalTo("FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP"))
            .withHeader("X-Time-Zone", equalTo("Europe/Rome"))
            .willReturn(okForJson(apiResponse)));
    var response =
        rest.exchange(
            "/api/account/{accountId}/transactions",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Transaction>>() {},
            accountId);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody())
        .usingRecursiveFieldByFieldElementComparator()
        .containsExactlyInAnyOrderElementsOf(apiResponse.getPayload().getList());
  }

  @ParameterizedTest
  @InstancioSource
  void createTransferTest(long accountId, TransferRequest transferRequest) {
    var apiResponse =
        Instancio.of(BaseResponse.class)
            .withTypeParameters(String.class)
            .ignore(field(BaseResponse<String>::getPayload))
            .create();
    stubFor(
        post(urlPathTemplate("/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers"))
            .withPathParam("accountId", equalTo(Long.toString(accountId)))
            .withHeader("Auth-Schema", equalTo("S2S"))
            .withHeader("Api-Key", equalTo("FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP"))
            .withHeader("X-Time-Zone", equalTo("Europe/Rome"))
            .willReturn(jsonResponse(apiResponse, HttpStatus.BAD_REQUEST.value())));
    var response =
        rest.postForEntity(
            "/api/account/{accountId}/transfer", transferRequest, Error.class, accountId);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getCode()).isEqualTo("API000");
    assertThat(response.getBody().getDescription())
        .isEqualTo(
            "Errore tecnico La condizione BP049 non e' prevista per il conto id " + accountId);
  }
}
