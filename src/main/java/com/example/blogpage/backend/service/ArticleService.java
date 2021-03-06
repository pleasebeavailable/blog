package com.example.blogpage.backend.service;

import com.example.blogpage.backend.model.Article;
import com.example.blogpage.backend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService{
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article findById(long id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article findByName(String name) {
        return articleRepository.findByName(name);
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
    public void delete(long id) {
        articleRepository.delete(articleRepository.findById(id).get());
    }


}
