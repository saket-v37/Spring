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


    // Create Todo
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


    // Get all Todo
    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos=todoRepo.findAll();
        if (todos.size()>0){
            return todos;
        }
        else {
            return new ArrayList<>();
        }
    }


    // Get Single Todo
    @Override
    public Todo getSingleTodo(String id) throws TodoCollectionException {
        Optional<Todo> optionalTodo=todoRepo.findById(id);
        if(optionalTodo.isEmpty()){
            throw new TodoCollectionException(TodoCollectionException.todoNotFoundException(id));
        }
        else {
            return optionalTodo.get();
        }
    }

    @Override
    public void updateTodo(String id, Todo todo) throws TodoCollectionException {
        Optional<Todo> todoWithId =todoRepo.findById(id);
        Optional<Todo> todoWithSameName=todoRepo.findByTodo(todo.getTodo());

        if (todoWithId.isPresent()){
            if (todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id)) {
                throw new TodoCollectionException(TodoCollectionException.todoAlreadyExist());
            }
            else {
                Todo todoToUpdate=todoWithId.get();

                todoToUpdate.setTodo(todo.getTodo()!=null ? todo.getTodo() :todoToUpdate.getTodo());
                todoToUpdate.setDescription(todo.getDescription()!=null ? todo.getDescription():todoToUpdate.getDescription());
                todoToUpdate.setCompleted(todo.getCompleted()!=null ? todo.getCompleted() : todoToUpdate.getCompleted());
                todoToUpdate.setUpdatedDate(new Date(System.currentTimeMillis()));
                todoRepo.save(todoToUpdate);
            }

        }
        else {
            throw new TodoCollectionException(TodoCollectionException.todoNotFoundException(id));
        }
    }

    @Override
    public void deleteTodo(String id) throws TodoCollectionException {

        Optional<Todo> optionalTodo=todoRepo.findById(id);
        if (optionalTodo.isEmpty()){
            throw new TodoCollectionException(TodoCollectionException.todoNotFoundException(id));
        }
        else {
            todoRepo.deleteById(id);
        }
    }


}
