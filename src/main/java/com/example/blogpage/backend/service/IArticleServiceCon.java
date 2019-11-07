package com.example.blogpage.backend.service;

import com.example.blogpage.backend.model.Article;

import java.util.List;
import java.util.Optional;

public interface IArticleServiceCon {
    List<Article> findAll();

    Optional<Article> findById(long id);

    Article saveOrUpdate(Article article);

    void save(Article article);

    void saveAll(List<Article> articleList);

    void delete(Article article);
}
