package com.example.mytodo.service;

import com.example.mytodo.model.Todo;

import java.util.List;
import java.util.function.Predicate;

public interface ITodoService {
    public List<Todo> findAll();
    public Todo findById(int id);
    public void addTodo(Todo todo);
    public void deleteTodo(int id) ;
    public void updateTodo(int id,Todo newTodo);
}
