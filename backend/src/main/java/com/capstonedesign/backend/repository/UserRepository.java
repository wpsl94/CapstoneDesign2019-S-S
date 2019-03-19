package com.capstonedesign.backend.repository;

import com.capstonedesign.backend.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
public class UserRepository {

    private final JedisPool jedisPool;

    @Autowired
    public UserRepository(JedisPool jedisPool) {

        this.jedisPool = jedisPool;
    }

    public void saveAccount(Account account) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(account.getId().toString(), account.getUserMid());
            jedis.sadd("User",account.getUserMid());
        }
    }

    public boolean isExistUser(Account account) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.sismember("User",account.getUserMid());
        }
    }
}
