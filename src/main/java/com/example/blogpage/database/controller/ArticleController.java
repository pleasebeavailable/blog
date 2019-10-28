package com.example.blogpage.database.controller;

import com.example.blogpage.database.model.Article;
import com.example.blogpage.database.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/bulkcreate")
    public String bulkCreate() {

        articleRepository.save(new Article("Article 1", "This is Article 1", "27-10-2019", "Ante"));
        articleRepository.saveAll(Arrays.asList(
                new Article("Article 2", "This is Article 2", "28-10-2019", "Ivan"),
                new Article("Article 3", "This is Article 3", "29-10-2019", "Frane"),
                new Article("Article 4", "This is Article 4", "30-10-2019", "MAte")
        ));

        return "Articles are created!";
    }

    @PostMapping("/create")
    public String create(@RequestBody Article article) {
        articleRepository.save(new Article(article.getName(), article.getText(), article.getDate(), article.getWriter()));

        return "Article is created";
    }

    @GetMapping("/findall")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @RequestMapping("/search/{id}")
    public String findById(@PathVariable long id) {
        String article = articleRepository.findById(id).toString();
        return article;
    }

    @RequestMapping("/searchName/{name}")
    public Article findByName(@PathVariable String name) {
        Article article = articleRepository.findByName(name);

        return article;
    }
}
