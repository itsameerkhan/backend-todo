package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo addTodo(@RequestHeader("X-User") String userName, @RequestBody Todo todo) {
        todo.setUserName(userName);
        return todoService.saveTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos(@RequestHeader("X-User") String userName) {
        return todoService.getTodosForUser(userName);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@RequestHeader("X-User") String userName, @PathVariable Long id) {
        todoService.deleteTodo(id, userName);
    }
}
