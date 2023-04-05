package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.SignUp;
import com.tweteroo.api.repository.AuthRepository;

@Service
public class AuthService {

  @Autowired
  private AuthRepository repository;

  public void signUp(SignUp data) {

    repository.save(data);
  }

}
