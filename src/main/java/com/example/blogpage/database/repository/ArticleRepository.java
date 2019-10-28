package com.example.blogpage.database.repository;

import com.example.blogpage.database.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();
    Article findById(Integer id);
    Article findByName(String name);
}
