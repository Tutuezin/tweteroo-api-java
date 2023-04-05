package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.SignUp;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repository.AuthRepository;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private AuthRepository authRepository;

  public void create(TweetDTO req) {
    List<SignUp> user = authRepository.findByUsername(req.username());

    if (!user.isEmpty()) {
      tweetRepository.save(new Tweet(req, user.get(0).getAvatar()));
    }

  }

  public List<Tweet> getAll(int page) {
    Pageable elements = PageRequest.of(page, 5);
    Page<Tweet> tweetsByPage = tweetRepository.findAll(elements);

    return tweetsByPage.getContent();
  }

  public List<Tweet> getAllTweetsByUserName(String username) {
    return tweetRepository.findByUsername(username);
  }

}
