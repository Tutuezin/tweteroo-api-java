package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")

public class TweetController {
  @Autowired
  private TweetService tweetService;

  @PostMapping
  public void create(@RequestBody @Valid TweetDTO req) {
    tweetService.create(req);
  }

  @GetMapping()
  public List<Tweet> getAll(@RequestParam(required = false, defaultValue = "0") Integer page) {
    return tweetService.getAll(page);
  }

  @GetMapping("/{username}")
  public List<Tweet> getAllTweetsByUserName(@PathVariable String username) {
    return tweetService.getAllTweetsByUserName(username);
  }
}
