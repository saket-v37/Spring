package com.saketProject.springMongoCrud.service;

import com.saketProject.springMongoCrud.exception.TodoCollectionException;
import com.saketProject.springMongoCrud.model.Todo;
import com.saketProject.springMongoCrud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService implements TodoServiceImpl {
    @Autowired
    private TodoRepository todoRepo;

    @Override
    public void createTodo(Todo todo) throws ConstraintViolationException, TodoCollectionException {
        Optional<Todo>optionalTodo=todoRepo.findByTodo(todo.getTodo());
        if (optionalTodo.isPresent()){
            throw new TodoCollectionException(TodoCollectionException.todoAlreadyExist());
        }
        else {
            todo.setCreatedDate(new Date(System.currentTimeMillis()));
            todoRepo.save(todo);
        }

    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos=todoRepo.findAll();
        if (todos.size()>0){
            return todos;
        }
        else {
            return new ArrayList<>();
        }
    }
}
