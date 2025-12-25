package com.example.demo.controllers;

import com.example.demo.model.Todo;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("{id}")
    public ResponseEntity<Todo> get(@PathVariable Integer id){
        return ResponseEntity.ok(todoService.getTodo(id));
    }
}
