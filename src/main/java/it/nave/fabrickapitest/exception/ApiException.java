package it.nave.fabrickapitest.exception;

public class ApiException extends RuntimeException {
  private final String code;
  private final String description;

  public ApiException(String code, String description, Throwable cause) {
    super(code + " | " + description, cause);
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }
}
