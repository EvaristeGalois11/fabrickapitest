package it.nave.fabrickapitest.controller;

import it.nave.fabrickapitest.controller.model.*;
import it.nave.fabrickapitest.controller.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "account")
public class AccountController {

  private final ApiService apiService;

  public AccountController(ApiService apiService) {
    this.apiService = apiService;
  }

  @GetMapping
  public AccountsResponse getAllAccounts() {
    return apiService.accounts();
  }

  @GetMapping(path = "{accountId}")
  public AccountResponse getAccount(@PathVariable long accountId) {
    return apiService.account(accountId);
  }

  @GetMapping(path = "{accountId}/balance")
  public Balance getBalance(@PathVariable long accountId) {
    return apiService.balance(accountId);
  }
}
