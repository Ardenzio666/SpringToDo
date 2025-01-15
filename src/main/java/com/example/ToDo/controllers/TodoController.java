package com.example.ToDo.controllers;

import com.example.ToDo.controllers.api.TodoApi;
import com.example.ToDo.dto.TodoDto;
import com.example.ToDo.services.CategoryService;
import com.example.ToDo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController implements TodoApi {

    @Autowired
    private TodoService todoService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<TodoDto> createTodo(TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TodoDto> updateTodo(TodoDto todoDto) {
        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TodoDto> getTodo(Long todoId) {
        return  new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteTodo(Long id) {
        return null;
    }
}
