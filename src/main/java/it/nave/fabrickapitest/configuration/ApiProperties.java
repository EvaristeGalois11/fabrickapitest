package it.nave.fabrickapitest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fabrick.api")
public class ApiProperties {
  private String baseUrl;
  private String authSchema;
  private String key;

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String getAuthSchema() {
    return authSchema;
  }

  public void setAuthSchema(String authSchema) {
    this.authSchema = authSchema;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
