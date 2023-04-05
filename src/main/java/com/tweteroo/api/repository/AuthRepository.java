package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.SignUp;

public interface AuthRepository extends JpaRepository<SignUp, Long> {
  List<SignUp> findByUsername(String username);

}
