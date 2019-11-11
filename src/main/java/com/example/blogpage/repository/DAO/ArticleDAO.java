package com.example.blogpage.repository.DAO;

import com.example.blogpage.repository.ArticleRepository;
import com.example.blogpage.repository.model.Article;
import com.example.blogpage.web.DTO.ArticleDTO;
import com.example.blogpage.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDAO implements IArticleDAO {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticle(long id) {

        Article article = articleRepository.findById(id).get();
        return article;
    }

    @Override
    public Article createArticle(Article article) {

        Article newArticle = articleRepository.save(article);
        return newArticle;
    }

    @Override
    public Article updateArticle(long id, Article updateArticle) {

        return articleRepository.findById(id)
                .map(article -> {
                    article.setName(updateArticle.getName());
                    article.setText(updateArticle.getText());
                    article.setDate(updateArticle.getDate());
                    article.setWriter(updateArticle.getWriter());
                    Article art = articleRepository.save(article);
                    return art;
                }).orElseThrow(() -> new NotFoundException("Article with id: " + id + " was not found!"));
    }

    @Override
    public ResponseEntity<Object> delete(long id) {

        return articleRepository.findById(id)
                .map(article -> {
                    articleRepository.delete(article);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new NotFoundException("Article with id: " + id + " is not found!"));
    }
}
