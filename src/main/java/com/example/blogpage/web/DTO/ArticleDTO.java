package com.example.blogpage.web.DTO;

import java.io.Serializable;

public class ArticleDTO implements Serializable {

    private long id;

    private String name;

    private String text;

    private String date;

    private String writer;

    public ArticleDTO() {
    }


    public ArticleDTO(String name, String text, String date, String writer) {
        this.name = name;
        this.text = text;
        this.date = date;
        this.writer = writer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
}
