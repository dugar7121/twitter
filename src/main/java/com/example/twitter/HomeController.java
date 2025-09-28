package com.example.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private TweetService tweetService;

    @GetMapping("/")
    public String homePage(Model model) {
        // Загружаем все твиты из базы данных
        model.addAttribute("tweets", tweetService.getAllTweets());
        return "home"; // Это будет имя HTML-шаблона
    }

    @PostMapping("/addTweet")
    public String addTweet(@RequestParam String content) {
        // Создаем новый твит
        Tweet tweet = new Tweet();
        tweet.setContent(content);
        tweetService.saveTweet(tweet);
        return "redirect:/"; // Перенаправляем на главную страницу после добавления
    }
}
//Этот контроллер будет отвечать за отображение главной страницы и обработку запросов для создания твитов.