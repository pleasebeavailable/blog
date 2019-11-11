package com.example.blogpage.repository.DAO;

import com.example.blogpage.repository.ArticleRepository;
import com.example.blogpage.repository.CommentRepository;
import com.example.blogpage.repository.model.Comment;
import com.example.blogpage.web.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentDAO implements ICommentDAO {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Comment> getCommentsByArticleId(long articleId) {
        return commentRepository.findByArticleId(articleId);
    }

    @Override
    public Comment getComment(long articleId, long commentId) {
        Comment comment = commentRepository.findByIdAndArticleId(commentId, articleId).get();
        return comment;
    }

    @Override
    public Comment createComment(long articleId, Comment comment) {
        return articleRepository.findById(articleId).map(article -> {
            comment.setArticle(article);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new NotFoundException("ArticleId " + articleId + " not found!"));
    }

    @Override
    public Comment updateComment(long articleId, long commentId, Comment updateComment) {

        if(!articleRepository.existsById(articleId)) {
            throw new NotFoundException("ArticleId " + articleId + " not found!");
        }

        return commentRepository.findById(commentId)
                .map(comment -> {
                    comment.setText(comment.getText());
                    Comment com = commentRepository.save(comment);
                    return com;
                }).orElseThrow(() -> new NotFoundException("Comment with id: " + commentId + " was not found!"));
    }

    @Override
    public ResponseEntity<?> delete(long articleId, long commentId) {
        return commentRepository.findByIdAndArticleId(commentId, articleId)
                .map(comment -> {
                    commentRepository.delete(comment);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new NotFoundException("Comment with id: " + commentId + " is not found!"));
    }
}
