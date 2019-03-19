package com.capstonedesign.backend.redisconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String HOST;

    @Value("${redis.port}")
    private Integer PORT;

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(new JedisPoolConfig(), HOST, PORT);
    }
}
