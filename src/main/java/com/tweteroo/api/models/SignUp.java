package com.tweteroo.api.models;

import com.tweteroo.api.dto.AuthDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class SignUp {

  public SignUp(AuthDTO req) {
    this.username = req.username();
    this.avatar = req.avatar();
  
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;

  private String avatar;

}
