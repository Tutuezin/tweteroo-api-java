package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.AuthDTO;
import com.tweteroo.api.models.SignUp;
import com.tweteroo.api.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/sign-up")

public class AuthController {

  @Autowired
  private AuthService service;

  @PostMapping
  public void signUp(@RequestBody @Valid AuthDTO req) {

    service.signUp(new SignUp(req));
  }

}
