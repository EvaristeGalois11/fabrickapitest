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
package it.nave.fabrickapitest.configuration;

import it.nave.fabrickapitest.exchange.ApiExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ExchangeConfiguration {
  private static final String AUTH_SCHEMA_HEADER = "Auth-Schema";
  private static final String API_KEY_HEADER = "Api-Key";
  private static final String TIMEZONE_HEADER = "X-Time-Zone";
  private static final String DEFAULT_TIMEZONE = "Europe/Rome";

  @Bean
  public ApiExchange apiExchange(ApiProperties apiProperties) {
    var restClient = buildRestClient(apiProperties);
    return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
        .build()
        .createClient(ApiExchange.class);
  }

  private RestClient buildRestClient(ApiProperties apiProperties) {
    return RestClient.builder()
        .baseUrl(apiProperties.getBaseUrl())
        .defaultHeader(AUTH_SCHEMA_HEADER, apiProperties.getAuthSchema())
        .defaultHeader(API_KEY_HEADER, apiProperties.getKey())
        .defaultHeader(API_KEY_HEADER, apiProperties.getKey())
        .defaultHeader(TIMEZONE_HEADER, DEFAULT_TIMEZONE)
        .build();
  }
}
