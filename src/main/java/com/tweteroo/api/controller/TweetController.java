package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.SignUp;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repository.AuthRepository;
import com.tweteroo.api.repository.TweetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")

public class TweetController {
  @Autowired
  private TweetRepository repository;

  @Autowired
  private AuthRepository authRepository;

  @PostMapping
  public void create(@RequestBody @Valid TweetDTO req) {
    List<SignUp> user = authRepository.findByUsername(req.username());

    if (!user.isEmpty()) {
      repository.save(new Tweet(req, user.get(0).getAvatar()));
    }

  }

  @GetMapping()
  public List<Tweet> getAll() {
    return repository.findAll();
  }
}
