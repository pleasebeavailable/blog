package com.example.blogpage;

import com.example.blogpage.repository.ArticleRepository;
import com.example.blogpage.repository.model.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BlogPageApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogPageApplication.class, args);

    }
}
