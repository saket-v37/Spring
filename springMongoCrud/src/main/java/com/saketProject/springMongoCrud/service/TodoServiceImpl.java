package com.saketProject.springMongoCrud.service;

import com.saketProject.springMongoCrud.exception.TodoCollectionException;
import com.saketProject.springMongoCrud.model.Todo;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoServiceImpl {
    public void createTodo(Todo todo) throws ConstraintViolationException, TodoCollectionException;
    public List<Todo> getAllTodos();
    public Todo getSingleTodo(String id) throws TodoCollectionException;
    public void updateTodo(String id, Todo todo) throws TodoCollectionException;
    public void deleteTodo(String id) throws TodoCollectionException;
}
