package com.example.blogpage.backend.ModelGUI;

public class ArticleGUI {

    private long id;

    private String name;

    private String text;

    private String date;

    private String writer;

    public ArticleGUI() {}

    public ArticleGUI(long id, String name, String text, String date, String writer) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
        this.writer = writer;
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
}
