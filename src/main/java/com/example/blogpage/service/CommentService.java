package com.example.blogpage.service;

import com.example.blogpage.repository.DAO.ICommentDAO;
import com.example.blogpage.repository.model.Comment;
import com.example.blogpage.web.DTO.CommentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentDAO commentDAO;
    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<CommentDTO> getComments(long articleId) {
        List<Comment> comments = commentDAO.getCommentsByArticleId(articleId);
        List<CommentDTO> DtoComments = new ArrayList<>();
        for (Comment com :
                comments) {
            DtoComments.add(modelMapper.map(com, CommentDTO.class));
        }

        return DtoComments;
    }

    @Override
    public CommentDTO getComment(long articleId, long commentId) {
        Comment comment = commentDAO.getComment(articleId, commentId);

        return modelMapper.map(comment, CommentDTO.class);
    }

    @Override
    public CommentDTO createComment(long articleId, Comment comment) {
        Comment created = commentDAO.createComment(articleId, comment);

        return modelMapper.map(created, CommentDTO.class);
    }

    @Override
    public CommentDTO updateComment(long articleId, long commentId, Comment comment) {
        Comment updated = commentDAO.updateComment(articleId, commentId, comment);

        return modelMapper.map(updated, CommentDTO.class);
    }

    @Override
    public ResponseEntity<?> delete(long articleId, long commentId) {

        return commentDAO.delete(articleId, commentId);
    }
}
