package com.capstonedesign.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Repository
public class PostRepository {

    private final JedisPool jedisPool;

    @Autowired
    public PostRepository(JedisPool jedisPool) {

        this.jedisPool = jedisPool;
    }

    public void addImageTagAndUrlSet(String postId, Set<String> imageTagAndUrlSet) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.sadd("postImage::"+ postId, imageTagAndUrlSet.toArray(new String[0]));
        }
    }
}
