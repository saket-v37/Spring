package com.SpringBoot.BasicRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private Book book;
    @GetMapping("/books")
    public List<Book> showBooks(){
        return Arrays.asList(new Book(1,"The Light",700));

    }

}
