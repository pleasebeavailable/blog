package com.example.blogpage.service;

import com.example.blogpage.repository.model.Comment;
import com.example.blogpage.web.DTO.CommentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommentService {

    List<CommentDTO> getComments(long articleId);

    CommentDTO getComment(long articleId, long commentId);

    CommentDTO createComment(long articleId, Comment comment);

    CommentDTO updateComment(long articleId, long commentId, Comment comment);

    ResponseEntity<?> delete(long articleId, long commentId);
}
