package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.RedisClient;

@Configuration
public class RedisConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public RedisClient redisClient(){
        return RedisClient.create(env.getProperty("redis.host"),
                Integer.parseInt(env.getProperty("redis.port")));
    }
}
