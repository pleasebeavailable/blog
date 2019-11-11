package com.example.blogpage.web.controller;

import com.example.blogpage.repository.model.Comment;
import com.example.blogpage.service.ICommentService;
import com.example.blogpage.web.DTO.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private ICommentService commentService;


    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDTO> findAll(@PathVariable long articleId) {

        return commentService.getComments(articleId);
    }

    @GetMapping("/articles/{articleId}/comments/{commentid}")
    public CommentDTO findById(@PathVariable long articleId, @PathVariable long commentId) {

        return commentService.getComment(articleId, commentId);
    }

    @PostMapping("/articles/{articleId}/comments")
    public CommentDTO createcomment(@PathVariable long articleId, @RequestBody Comment comment) {

        return commentService.createComment(articleId, comment);
    }

    @PutMapping("/articles/{articleId}/comments/{id}")
    public CommentDTO updatecomment(@PathVariable long articleId, @PathVariable long commentId, @RequestBody Comment comment) {

        return commentService.updateComment(articleId, commentId, comment);
    }

    @DeleteMapping("/article/{articleId}/comments/{id}")
    public ResponseEntity<?> deletecomment(@PathVariable long articleId, @PathVariable long commentId) throws Exception {

        return commentService.delete(articleId, commentId);
    }
}
