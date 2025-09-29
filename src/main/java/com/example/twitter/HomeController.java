package com.example.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private TweetService tweetService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("tweets", tweetService.getAllTweets());
        return "home";
    }

    @PostMapping("/addTweet")
    public String addTweet(@RequestParam String content) {
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweetService.saveTweet(tweet);
        return "redirect:/";
    }

    // Новый метод для редактирования твита
    @GetMapping("/editTweet/{id}")
    public String editTweet(@PathVariable Long id, Model model) {
        Tweet tweet = tweetService.getTweetById(id);
        model.addAttribute("tweet", tweet);
        return "editTweet"; // Шаблон для редактирования твита
    }

    @PostMapping("/saveEditedTweet")
    public String saveEditedTweet(@RequestParam Long id, @RequestParam String content) {
        Tweet tweet = tweetService.getTweetById(id);
        tweet.setContent(content);
        tweetService.saveTweet(tweet); // Сохраняем изменения
        return "redirect:/";
    }

    @GetMapping("/deleteTweet/{id}")
    public String deleteTweet(@PathVariable Long id) {
        tweetService.deleteTweet(id);
        return "redirect:/";
    }
}
