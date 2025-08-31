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
    public Todo addTodo(@RequestHeader(value = "X-User", required = false) String userName,
                        @RequestBody Todo todo) {
        if (userName == null || userName.isEmpty()) {
            userName = "guest"; // default if not provided
        }
        todo.setUserName(userName);
        return todoService.saveTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos(@RequestHeader(value = "X-User", required = false) String userName) {
        if (userName == null || userName.isEmpty()) {
            userName = "guest";
        }
        return todoService.getTodosForUser(userName);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@RequestHeader(value = "X-User", required = false) String userName,
                           @PathVariable Long id) {
        if (userName == null || userName.isEmpty()) {
            userName = "guest";
        }
        todoService.deleteTodo(id, userName);
    }
}
