package com.example.blogpage.repository.DAO;

import com.example.blogpage.repository.model.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommentDAO {

    List<Comment> getCommentsByArticleId(long articleId);

    Comment getComment(long articleId, long commentId);

    Comment createComment(long articleId, Comment comment);

    Comment updateComment(long articleId, long commentId, Comment updateComment);

    ResponseEntity<?> delete(long articleId, long commentId);

}
