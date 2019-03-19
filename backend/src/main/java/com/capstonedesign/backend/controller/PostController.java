package com.capstonedesign.backend.controller;

import com.capstonedesign.backend.domain.Post;
import com.capstonedesign.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/postcreate")
    public void postCreate(@RequestBody Post post) {

        postService.createPost(post);
    }

    @PostMapping(path = "/postedit")
    public void postEdit(@RequestBody Post post) {

        postService.editPost(post);
    }

    @PostMapping(path = "/postdelete")
    public void postDelete(@RequestBody Post post) {

        postService.deletePost(post);
    }
}
