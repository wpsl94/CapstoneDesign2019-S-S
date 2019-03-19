package com.capstonedesign.backend.controller;

import com.capstonedesign.backend.domain.Comment;
import com.capstonedesign.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CommentController {

    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/commentcreate")
    public void commentCreate(@RequestBody Comment comment) {

        commentService.createComment(comment);
    }

    @PostMapping(path = "/commentedit")
    public void commentEdit(@RequestBody Comment comment) {

        commentService.editComment(comment);
    }

    @PostMapping(path = "/commentdelete")
    public void commentDelete(@RequestBody Comment comment) {

        commentService.deleteComment(comment);
    }
}
