package com.example.blogpage.backend.service;

import com.example.blogpage.backend.ModelGUI.ArticleGUI;
import com.example.blogpage.backend.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArticleService {

    List<ArticleGUI> getArticles();

    ArticleGUI getArticle(long id);

    ArticleGUI createArticle(Article article);

    ArticleGUI updateArticle(long id, Article article);

    ResponseEntity<Object> delete(long id);
}
