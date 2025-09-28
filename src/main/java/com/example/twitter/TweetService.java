package com.example.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet saveTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }
}
//отвечает за добавление и получение твитов. Убедимся, что в нем есть метод для получения всех твитов.