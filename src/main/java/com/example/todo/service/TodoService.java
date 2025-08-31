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

    public List<Todo> getTodosForUser(String userName) {
        return todoRepository.findByUserNameOrderByIdAsc(userName);
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id, String userName) {
        todoRepository.findById(id).ifPresent(t -> {
            if (t.getUserName().equals(userName)) {
                todoRepository.deleteById(id);
            }
        });
    }
}
