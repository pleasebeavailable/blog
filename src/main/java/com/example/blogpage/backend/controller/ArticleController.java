package com.example.blogpage.backend.controller;

import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/bulkcreate")
//    public String bulkCreate(Model model) {
//
//        articleService.save(new Article("Article 1", "This is Article 1", "27-10-2019", "Ante"));
//        articleService.saveAll(Arrays.asList(
//                new Article("Article 2", "This is Article 2", new Date(2019, 10, 28 ), "Ivan"),
//                new Article("Article 3", "This is Article 3", "29-10-2019", "Frane"),
//                new Article("Article 4", "This is Article 4", "30-10-2019", "MAte")
//        ));
//        model.addAttribute("articles", new ArrayList<>());
//
//        return "redirect:/";
//    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("article", new Article());

        return "articleform";
    }

    @PostMapping("/addarticle")
    public String addArticle(Article article, Model model) {
        articleService.save(article);

        return "articlelist";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", new ArrayList<>());

        return "index";
    }
    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articlelist";
    }

    /*@RequestMapping("/search/{id}")
    public String findById(@PathVariable long id) {
        String article = articleService.findById(id).toString();
        return article;
    }
    */
    @RequestMapping("/searchName/{name}")
    public Article findByName(@PathVariable String name) {
        Article article = articleService.findByName(name);

        return article;
    }


}
