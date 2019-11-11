package com.example.blogpage.web.controller;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ArticleControllerTest {

    private MockMvc mockMvc;

    private ArticleController articleController;

    @Before
    public void setup() {
        articleController = new ArticleController();
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
    }


}
