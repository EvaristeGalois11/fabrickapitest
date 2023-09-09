package it.nave.fabrickapitest.controller;

import it.nave.fabrickapitest.exception.ApiException;
import it.nave.fabrickapitest.model.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error apiException(ApiException apiException) {
    logger.error("Something went wrong", apiException);
    return new Error(apiException.getCode(), apiException.getDescription());
  }
}
