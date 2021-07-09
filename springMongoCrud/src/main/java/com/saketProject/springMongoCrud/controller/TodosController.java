package com.saketProject.springMongoCrud.controller;


import com.saketProject.springMongoCrud.exception.TodoCollectionException;
import com.saketProject.springMongoCrud.model.Todo;
import com.saketProject.springMongoCrud.repository.TodoRepository;
import com.saketProject.springMongoCrud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
public class TodosController {

    @Autowired
    private TodoRepository todoRepo;

    @Autowired
    private TodoService todoService;


    // Read todos
    @GetMapping(path = "/todos")
    public ResponseEntity<?> getAllTodos(){
        List<Todo> todos=todoService.getAllTodos();
        return new ResponseEntity<>(todos,todos.size()>0 ?HttpStatus.OK :HttpStatus.NOT_FOUND);
    }


    // Create TODOs
    @PostMapping(path = "/todos")
    public ResponseEntity<?> createTodos(@RequestBody Todo newTodo){
        try {
            todoService.createTodo(newTodo);
            return  new ResponseEntity<Todo>(newTodo,HttpStatus.CREATED);
        }
        catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (TodoCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }



    // Find TODOs with ID:
    @GetMapping(path = "/todos/{id}")
    public ResponseEntity<?> findTodos(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(todoService.getSingleTodo(id),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    // Update TODOs
    @PutMapping(path = "/todos/{id}")
    public ResponseEntity<?> updateTodos(@PathVariable("id") String id,@RequestBody Todo newTodo){
        try {
            todoService.updateTodo(id,newTodo);
            return new ResponseEntity<>("todo updated with id: "+id,HttpStatus.OK);
        }
        catch (ConstraintViolationException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (TodoCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    // Delete TODOs
    @DeleteMapping(path = "/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id){
        try {
            todoService.deleteTodo(id);
            return new ResponseEntity<>("Successfully deleted the Todo with id: "+id,HttpStatus.OK);
        }
        catch (TodoCollectionException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}



//    // Read todos  --OLD CODE--
//    @GetMapping(path = "/todos")
//    public ResponseEntity<?> getAllTodos(){
//        List<Todo> todos=todoRepo.findAll();
//        if (todos.size()>0){
//            return new ResponseEntity<List<Todo>>(todos, HttpStatus.OK);
//        }
//        else {
//            return  new ResponseEntity<>("No todo found",HttpStatus.NOT_FOUND);
//        }
//    }



//    // Create TODOs   ---OLD CODE---
//    @PostMapping(path = "/todos")
//    public ResponseEntity<?> createTodos(@RequestBody Todo newTodo){
//        try {
//            newTodo.setCreatedDate(new Date((System.currentTimeMillis())));
//            todoRepo.insert(newTodo);
//            return  new ResponseEntity<Todo>(newTodo,HttpStatus.CREATED);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }


// Update TODOs -- OLD CODE --
//    @PutMapping(path = "/todos/{id}")
//    public ResponseEntity<?> updateTodos(@PathVariable("id") String id,@RequestBody Todo newTodo){
//        Optional<Todo> optionalTodo=todoRepo.findById(id);
//        if(optionalTodo.isPresent()) {
//            Todo todoToSave=optionalTodo.get();
//
//            todoToSave.setCompleted(newTodo.getCompleted() != null ? newTodo.getCompleted():todoToSave.getCompleted());
//            todoToSave.setTodo(newTodo.getTodo()!=null? newTodo.getTodo():todoToSave.getTodo());
//            todoToSave.setDescription(newTodo.getDescription()!=null ? newTodo.getDescription():todoToSave.getDescription());
//            todoToSave.setUpdatedDate(new Date(System.currentTimeMillis()));
//            todoRepo.save(todoToSave);
//            return new ResponseEntity<Todo>(todoToSave,HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("todo not found with id:"+id,HttpStatus.NOT_FOUND);
//        }
//    }


// Find TODO with ID:  -- OLD Code--
//    @GetMapping(path = "/todos/{id}")
//    public ResponseEntity<?> findTodos(@PathVariable("id") String id){
//            Optional<Todo> todo=todoRepo.findById(id);
//            if(todo.isPresent()) {
//                return new ResponseEntity<>(todo.get(), HttpStatus.FOUND);
//            }
//        else{
//            return new ResponseEntity<>("todo not found with id:"+id,HttpStatus.NOT_FOUND);
//        }
//    }


//    // Delete TODOs -- OLD CODE--
//    @DeleteMapping(path = "/todos/{id}")
//    public ResponseEntity<?> deleteTodo(@PathVariable String id){
//        Optional<Todo> optionalTodo=todoRepo.findById(id);
//        if (optionalTodo.isPresent()){
//            try {
//                todoRepo.deleteById(id);
//                return new ResponseEntity<>("successfully deleted with id :"+id,HttpStatus.OK);
//            }
//            catch (Exception e){
//                return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
//            }
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
