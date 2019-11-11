package com.example.blogpage.service;

import com.example.blogpage.repository.DAO.IArticleDAO;
import com.example.blogpage.repository.model.Article;
import com.example.blogpage.web.DTO.ArticleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDAO articleDAO;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ArticleDTO> getArticles() {
        List<Article> articles = articleDAO.getArticles();
        List<ArticleDTO> viewArticles = new ArrayList<>();
        for (Article article :
                articles) {
            viewArticles.add(modelMapper.map(article, ArticleDTO.class));
        }

        return viewArticles;
    }

    @Override
    public ArticleDTO getArticle(long id) {

        Article article = articleDAO.getArticle(id);
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public ArticleDTO createArticle(Article article) {

        Article newArticle = articleDAO.createArticle(article);
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public ArticleDTO updateArticle(long id, Article updateArticle) {

        Article article = articleDAO.updateArticle(id, updateArticle);
        return modelMapper.map(article, ArticleDTO.class);
    }

    /*
     * Delete must return ResponseEntity
     */
    @Override
    public ResponseEntity<Object> delete(long id) {

        return articleDAO.delete(id);
    }
}
