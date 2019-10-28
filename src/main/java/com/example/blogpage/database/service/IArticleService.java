package com.example.blogpage.database.service;

import com.example.blogpage.database.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findAll();

    Article findByName(String name);

    void save(Article article);

    void saveAll(List<Article> articleList);
}
