package com.example.blogpage.repository.DAO;

import com.example.blogpage.repository.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArticleDAO {
    List<Article> getArticles();

    Article getArticle(long id);

    Article createArticle(Article article);

    Article updateArticle(long id, Article updateArticle);

    ResponseEntity<Object> delete(long id);
}
