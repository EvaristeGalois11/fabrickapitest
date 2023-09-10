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