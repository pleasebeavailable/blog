package com.example.blogpage.repository.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="articles")
public class Article {

    public Article() {}

    public Article(String name, String text, String date, String writer) {
        this.name = name;
        this.text = text;
        this.date = date;
        this.writer = writer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private String date;

    @Column(name="writer")
    private String writer;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<Comment>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
