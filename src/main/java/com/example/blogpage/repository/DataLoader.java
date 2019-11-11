package com.example.blogpage.repository;

import com.example.blogpage.repository.DAO.IArticleDAO;
import com.example.blogpage.repository.model.Article;
import com.example.blogpage.repository.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private IArticleDAO articleDAO;
    private CommentRepository commentRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public DataLoader(IArticleDAO articleDAO, CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.articleDAO = articleDAO;
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    private void LoadData() {
        List<Article> listOfArticles = new ArrayList<>();
        listOfArticles.add(new Article("Article 1", "This is Article 1", "2019-10-28", "Ante"));
        listOfArticles.add(new Article("Article 2", "This is Article 2", "2019-10-29", "Frane"));
        listOfArticles.add(new Article("Article 3", "This is Article 3", "2019-10-30", "Ivan"));
        listOfArticles.add(new Article("Article 4", "This is Article 4", "2019-10-31", "David"));

        articleRepository.saveAll(listOfArticles);

        List<Comment> listOfComments = new ArrayList<>();

        listOfComments.add(new Comment("Franck", "Great Article!", articleDAO.getArticle(1)));
        listOfComments.add(new Comment("Vlago", "Great Article!", articleDAO.getArticle(1)));
        listOfComments.add(new Comment("Branko", "Great Article!", articleDAO.getArticle(1)));

        commentRepository.saveAll(listOfComments);
        listOfComments.clear();

        listOfComments.add(new Comment("Brane", "Great Article!", articleDAO.getArticle(2)));
        listOfComments.add(new Comment("Šuks", "Great Article!", articleDAO.getArticle(2)));
        listOfComments.add(new Comment("Baks", "Great Article!", articleDAO.getArticle(2)));

        commentRepository.saveAll(listOfComments);
        listOfComments.clear();

        listOfComments.add(new Comment("Boris", "Great Article!", articleDAO.getArticle(3)));
        listOfComments.add(new Comment("David", "Great Article!", articleDAO.getArticle(3)));
        listOfComments.add(new Comment("Igor", "Great Article!", articleDAO.getArticle(3)));

        commentRepository.saveAll(listOfComments);
        listOfComments.clear();

        listOfComments.add(new Comment("Josipa", "Great Article!", articleDAO.getArticle(4)));
        listOfComments.add(new Comment("Martina", "Great Article!", articleDAO.getArticle(4)));
        listOfComments.add(new Comment("Ivana", "Great Article!", articleDAO.getArticle(4)));

        commentRepository.saveAll(listOfComments);
        listOfComments.clear();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LoadData();
    }
}
