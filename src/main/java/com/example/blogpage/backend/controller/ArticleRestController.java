package com.example.blogpage.backend.controller;

import com.example.blogpage.backend.ModelGUI.ArticleGUI;
import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.service.serviceimpl.ArticleService;
import com.example.blogpage.backend.service.serviceimpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@Profile("angular")
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @GetMapping("/articles")
    public List<ArticleGUI> findAll(Model model) {

        return articleService.getArticles();
    }

    @GetMapping("/articles/{id}")
    public ArticleGUI findById(@PathVariable long id) {

        return articleService.getArticle(id);
    }

    @PostMapping("/articles")
    public ArticleGUI createArticle(@RequestBody Article article) {

        return articleService.createArticle(article);
    }

    @PutMapping("/articles/{id}")
    public ArticleGUI updateArticle(@PathVariable long id, @RequestBody Article article) throws Exception {

        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Object> deleteArticle(@PathVariable long id) throws Exception {

        return articleService.delete(id);


    }

}
