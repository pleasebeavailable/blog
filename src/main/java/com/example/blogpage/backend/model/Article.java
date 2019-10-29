package com.example.blogpage.backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="articles")
public class Article implements Serializable {

    public Article() {}

    public Article(String name, String text, String article_date, String writer) {
        this.name = name;
        this.text = text;
        this.article_date = article_date;
        this.writer = writer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="text")
    private String text;

    @Column(name="article_date")
    private String article_date;

    @Column(name="writer")
    private String writer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return article_date;
    }

    public void setDate(String article_date) {
        this.article_date = article_date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
