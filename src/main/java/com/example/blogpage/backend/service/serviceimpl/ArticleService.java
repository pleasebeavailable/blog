package com.example.blogpage.backend.service.serviceimpl;

import com.example.blogpage.backend.ModelGUI.ArticleGUI;
import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.repository.ArticleRepository;
import com.example.blogpage.backend.service.IArticleService;
import com.example.blogpage.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleGUI> getArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleGUI> viewArticles = new ArrayList<>();
        for (Article article :
                articles) {
            viewArticles.add(new ArticleGUI(article.getId(), article.getName(), article.getText(), article.getDate(), article.getWriter()));
        }

        return viewArticles;
    }

    @Override
    public ArticleGUI getArticle(long id) {

        Article article = articleRepository.findById(id).get();
        return new ArticleGUI(article.getId(), article.getName(), article.getText(), article.getDate(), article.getWriter());
    }

    @Override
    public ArticleGUI createArticle(Article article) {

        Article newArticle = articleRepository.save(article);
        return new ArticleGUI(newArticle.getId(), newArticle.getName(), newArticle.getText(), newArticle.getDate(), newArticle.getWriter());
    }

    @Override
    public ArticleGUI updateArticle(long id, Article updateArticle) {

        return articleRepository.findById(id)
                .map(article -> {
                    article.setName(updateArticle.getName());
                    article.setText(updateArticle.getText());
                    article.setDate(updateArticle.getDate());
                    article.setWriter(updateArticle.getWriter());
                    Article art = articleRepository.save(article);
                    return new ArticleGUI(art.getId(), art.getName(), art.getText(), art.getDate(), art.getWriter());
                }).orElseThrow(() -> new NotFoundException("Article with id: " + id + " was not found!"));
    }

    /*
    * Delete must return ResponseEntity
    */
    @Override
    public ResponseEntity<Object> delete(long id) {

        return articleRepository.findById(id)
                .map(article -> {
                    articleRepository.delete(article);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new NotFoundException("Article with id: " + id + " is not found!"));
    }

}
