package com.springboot.mongocrud.repository;

import com.springboot.mongocrud.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
