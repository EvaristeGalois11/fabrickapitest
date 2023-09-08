package it.nave.fabrickapitest.controller.configuration;

import it.nave.fabrickapitest.controller.exchange.ApiExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ExchangeConfiguration {
  private static final String AUTH_SCHEMA_HEADER = "Auth-Schema";
  private static final String API_KEY_HEADER = "Api-Key";

  private static final String baseUrl = "https://sandbox.platfr.io";
  private static final String authSchema = "S2S";
  private static final String apiKey = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";

  @Bean
  public ApiExchange apiExchange() {
    return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(buildRestClient()))
        .build()
        .createClient(ApiExchange.class);
  }

  private RestClient buildRestClient() {
    return RestClient.builder()
        .baseUrl(baseUrl)
        .defaultHeader(AUTH_SCHEMA_HEADER, authSchema)
        .defaultHeader(API_KEY_HEADER, apiKey)
        .build();
  }
}
