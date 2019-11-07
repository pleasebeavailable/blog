package com.example.blogpage.backend.service.serviceimpl;

import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.repository.ArticleRepository;
import com.example.blogpage.backend.service.IArticleServiceCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceCon implements IArticleServiceCon {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article saveOrUpdate(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void saveAll(List<Article> articleList) {
        articleRepository.saveAll(articleList);
    }

    @Override
    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
