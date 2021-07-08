package com.saketProject.springMongoCrud.service;

import com.saketProject.springMongoCrud.exception.TodoCollectionException;
import com.saketProject.springMongoCrud.model.Todo;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface TodoServiceImpl {
    public void createTodo(Todo todo) throws ConstraintViolationException, TodoCollectionException;
    public List<Todo> getTodos();
}
