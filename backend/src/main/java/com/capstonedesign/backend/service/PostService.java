package com.capstonedesign.backend.service;

import com.capstonedesign.backend.domain.Post;
import com.capstonedesign.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void createPost(Post post) {

        postRepository.savePost(post);
    }
}
