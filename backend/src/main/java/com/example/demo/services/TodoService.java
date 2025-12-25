package com.example.demo.services;

import com.example.demo.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import redis.clients.jedis.RedisClient;
import tools.jackson.databind.ObjectMapper;

@Service
public class TodoService {

    private final RestClient restClient;
    private final RedisClient redisClient;
    private final ObjectMapper objectMapper;

    public TodoService(RedisClient redisClient) {
        this.restClient = RestClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
        this.redisClient = redisClient;
        objectMapper = new ObjectMapper();
    }

    public Todo getTodo(int id){
        Todo todo = getTodoFromCache(id);
        if(todo == null){
            todo = getTodoFromApi(id);
            cacheTodo(todo);
        }
        return todo;
    }

    private Todo getTodoFromCache(int id){
        Object cachedObject = redisClient.jsonGet(String.valueOf(id));
        if(cachedObject == null){
            return null;
        }
        return objectMapper.convertValue(cachedObject, Todo.class);
    }

    private Todo getTodoFromApi(int id) {
        try {
            Thread.sleep(3000); // simulate network delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.restClient.get().uri("/todos/{id}", id).retrieve().body(Todo.class);
    }

    /**
     * Caches a Todo for 15 seconds
     * @param todo
     */
    private void cacheTodo(Todo todo){
        var todoKey = String.valueOf(todo.id());
        redisClient.jsonSetWithEscape(todoKey, todo);
        redisClient.expire(todoKey, 15);
    }
}
