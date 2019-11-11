package com.example.blogpage.web.DTO;

import java.io.Serializable;

public class CommentDTO implements Serializable {

    private long id;
    private String comentator;
    private String text;

    public CommentDTO() {
    }

    public CommentDTO(long id, String comentator, String text) {
        this.id = id;
        this.comentator = comentator;
        this.text = text;
    }

    public long getId() {
        return id;
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

}
