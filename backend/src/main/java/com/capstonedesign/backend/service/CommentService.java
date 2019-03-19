package com.capstonedesign.backend.service;

import com.capstonedesign.backend.domain.Comment;
import com.capstonedesign.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void createComment(Comment comment) {

        commentRepository.saveComment(comment);
    }

    public void editComment(Comment comment) {

        commentRepository.saveComment(comment);
    }

    public void deleteComment(Comment comment) {

        commentRepository.deleteComment(comment);
    }
}
