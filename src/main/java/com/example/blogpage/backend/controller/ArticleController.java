package com.example.blogpage.backend.controller;

import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.service.serviceimpl.ArticleServiceCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@CrossOrigin
@Profile("thymeleaf")
public class ArticleController {

    @Autowired
    private ArticleServiceCon articleServiceCon;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", new ArrayList<>());

        return "index";
    }

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("articles", articleServiceCon.findAll());
        return "articlelist";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("article", new Article());

        return "articleform";
    }

    @PostMapping("/addarticle")
    public String saveOrUpdate(Article article) {
        articleServiceCon.saveOrUpdate(article);

        return "redirect:findall";
    }

    @GetMapping("/view/{id}")
    public String viewArticle(@PathVariable long id, Model model) {
        model.addAttribute("article", articleServiceCon.findById(id).get());

        return "articleview";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("article", articleServiceCon.findById(id).get());

        return "articleform";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        Article article = articleServiceCon.findById(id).get();
        articleServiceCon.delete(article);

        return "redirect:/findall";
    }


    @GetMapping("/bulkcreate")
    public String bulkCreate(Model model) {

        articleServiceCon.save(new Article("Article 1", "This is Article 1", "27-10-2019", "Ante"));
        articleServiceCon.saveAll(Arrays.asList(
                new Article("Article 2", "This is Article 2", "28-10-2019", "Ivan"),
                new Article("Article 3", "This is Article 3", "29-10-2019", "Frane"),
                new Article("Article 4", "This is Article 4", "30-10-2019", "MAte")
        ));
        model.addAttribute("articles", new ArrayList<>());

        return "redirect:/";
    }

    @RequestMapping("/search/{id}")
    public String findById(@PathVariable long id) {
        String article = articleServiceCon.findById(id).toString();
        return article;
    }
}