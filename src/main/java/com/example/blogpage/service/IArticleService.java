package com.example.blogpage.service;

import com.example.blogpage.web.DTO.ArticleDTO;
import com.example.blogpage.repository.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArticleService {

    List<ArticleDTO> getArticles();

    ArticleDTO getArticle(long id);

    ArticleDTO createArticle(Article article);

    ArticleDTO updateArticle(long id, Article article);

    ResponseEntity<Object> delete(long id);

}
