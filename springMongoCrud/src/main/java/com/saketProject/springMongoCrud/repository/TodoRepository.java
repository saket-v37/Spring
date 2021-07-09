package com.saketProject.springMongoCrud.repository;

import com.saketProject.springMongoCrud.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository  extends MongoRepository<Todo,String>
{
    @Query("{'todo': ?0}")
    Optional<Todo> findByTodo(String todo);
}
