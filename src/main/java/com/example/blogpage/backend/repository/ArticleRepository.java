package com.example.blogpage.backend.repository;

import com.example.blogpage.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

//    List<Article> findByUserId(long userId);
}
