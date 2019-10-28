package com.example.blogpage.database.controller;

import com.example.blogpage.database.model.Article;
import com.example.blogpage.database.service.ArticleService;
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

    @GetMapping("/bulkcreate")
    public String bulkCreate(Model model) {

        articleService.save(new Article("Article 1", "This is Article 1", "27-10-2019", "Ante"));
        articleService.saveAll(Arrays.asList(
                new Article("Article 2", "This is Article 2", "28-10-2019", "Ivan"),
                new Article("Article 3", "This is Article 3", "29-10-2019", "Frane"),
                new Article("Article 4", "This is Article 4", "30-10-2019", "MAte")
        ));
        model.addAttribute("articles", new ArrayList<>());

        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@RequestBody Article article) {
        articleService.save(new Article(article.getName(), article.getText(), article.getDate(), article.getWriter()));

        return "index";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", new ArrayList<>());

        return "index";
    }
    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "index";
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
