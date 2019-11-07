package com.example.blogpage.backend.ModelGUI;

import com.example.blogpage.backend.model.Article;

import java.util.Set;

public class UserGUI {

    private long id;

    //    @Version
//    private Integer version;

    private String username;

    private Boolean enabled = true;

    private Set<Article> articles;

    public UserGUI() {
    }

    public UserGUI(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
