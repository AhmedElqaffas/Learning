package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.RedisClient;

@Configuration
public class RedisConfiguration {
    private final RedisProperties redisProperties;

    public RedisConfiguration(RedisProperties redisProperties){
        this.redisProperties = redisProperties;
    }

    @Bean
    public RedisClient redisClient(){
        return RedisClient.create(redisProperties.getHost(),
                redisProperties.getPort());
    }
}
