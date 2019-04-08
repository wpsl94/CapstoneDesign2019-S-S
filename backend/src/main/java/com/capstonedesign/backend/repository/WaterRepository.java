package com.capstonedesign.backend.repository;

import com.capstonedesign.backend.domain.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.Set;

@Repository
public class WaterRepository {

    private final JedisPool jedisPool;

    @Autowired
    public WaterRepository(JedisPool jedisPool) {

        this.jedisPool = jedisPool;
    }

    public void saveDrinkLog(Water water) {

        try (Jedis jedis = jedisPool.getResource()) {
            jedis.zadd("User:" + water.getUid(), System.currentTimeMillis(), water.getWaterDrink().toString());
        }
    }

    public Set<Tuple> getAllDrinkLog(Water water) {

        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.zrangeByScoreWithScores("User:" + water.getUid(), "-inf", "+inf");
        }
    }
}
