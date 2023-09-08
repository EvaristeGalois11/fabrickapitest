package it.nave.fabrickapitest.controller;

import it.nave.fabrickapitest.controller.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
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
  public String getAllAccounts() {
    return apiService.accounts();
  }
}
