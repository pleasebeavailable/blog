package com.example.blogpage.backend.service;

import com.example.blogpage.backend.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> findAll();

    Article findById(long id);

    Article findByName(String name);

    void save(Article article);

    void saveAll(List<Article> articleList);

    void delete(long id);
}
