package com.example.mytodo.service;

import com.example.mytodo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService implements ITodoService{
private static List<Todo> todos = new ArrayList<>();
private static int todoCount=0;

static {
    todos.add(new Todo(++todoCount, "learning springboot", false));
    todos.add(new Todo(++todoCount, "going to temple", false));
    todos.add(new Todo(++todoCount, "chilling with family and freinds", false));
    todos.add(new Todo(++todoCount, "playing game", false));
    todos.add(new Todo(++todoCount, "doing some dsa ", false));
}
@Override
public List<Todo> findAll(){
    return todos;
    }
    @Override
    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    @Override
    public void addTodo(Todo todo){
    todos.add(todo);
    }
    @Override
    public void deleteTodo(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
    @Override
    public void updateTodo(int id,Todo newTodo) {
        //step 1: find todo to be update
        //Step 2: update todo

        Todo todo=findById(id);// step 1

        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());

    }
}

