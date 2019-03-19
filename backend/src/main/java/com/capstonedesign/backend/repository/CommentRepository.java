package com.capstonedesign.backend.repository;

import com.capstonedesign.backend.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class CommentRepository {

    private final JedisPool jedisPool;

    @Autowired
    public CommentRepository(JedisPool jedisPool) {

        this.jedisPool = jedisPool;
    }

    public void saveComment(Comment comment) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zadd(comment.getCid().toString(), comment.getLike(), comment.toString());
        }
    }

    public void deleteComment(Comment comment) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(comment.getCid().toString());
        }
    }
}
