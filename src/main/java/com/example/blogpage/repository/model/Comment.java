package com.example.blogpage.repository.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String comentator;

    private String text;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;

    public long getId() {
        return id;
    }

    public Comment() {
    }

    public Comment(String comentator, String text, Article article) {
        this.comentator = comentator;
        this.text = text;
        this.article = article;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentator() {
        return comentator;
    }

    public void setComentator(String comentator) {
        this.comentator = comentator;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
