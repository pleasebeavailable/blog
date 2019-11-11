package com.example.blogpage.web.controller;

import com.example.blogpage.web.DTO.ArticleDTO;
import com.example.blogpage.repository.model.Article;
import com.example.blogpage.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    private IArticleService articleService;


    @GetMapping("/articles")
    public List<ArticleDTO> findAll() {

        return articleService.getArticles();
    }

    @GetMapping("/articles/{id}")
    public ArticleDTO findById(@PathVariable long id) {

        return articleService.getArticle(id);
    }

    @PostMapping("/articles")
    public ArticleDTO createArticle(@RequestBody Article article) {

        return articleService.createArticle(article);
    }

    @PutMapping("/articles/{id}")
    public ArticleDTO updateArticle(@PathVariable long id, @RequestBody Article article) throws Exception {

        return articleService.updateArticle(id, article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Object> deleteArticle(@PathVariable long id) throws Exception {

        return articleService.delete(id);
    }
}
