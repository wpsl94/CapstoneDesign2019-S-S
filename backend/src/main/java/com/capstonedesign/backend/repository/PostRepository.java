package com.capstonedesign.backend.repository;

import com.capstonedesign.backend.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class PostRepository {

    private final JedisPool jedisPool;

    @Autowired
    public PostRepository(JedisPool jedisPool) {

        this.jedisPool = jedisPool;
    }

    public void savePost(Post post) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zadd(post.getPid().toString(), post.getLike() + post.getCommentCount(), post.toString());
        }
    }
}
