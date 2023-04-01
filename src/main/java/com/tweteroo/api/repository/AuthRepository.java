package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.SignUp;

public interface AuthRepository extends JpaRepository<SignUp, Long> {

}
