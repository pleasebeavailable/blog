package com.example.blogpage.repository;

import com.example.blogpage.repository.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(long articleId);

    Optional<Comment> findByIdAndArticleId(long commentId, long articleId);

}
