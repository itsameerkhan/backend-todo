package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosForUser(String userName) {
        return todoRepository.findByUserName(userName);
    }

    public void deleteTodo(Long id, String userName) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        if (todo.getUserName().equals(userName)) {
            todoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Not allowed to delete this todo");
        }
    }
}
