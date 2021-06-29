package com.springBooot.restfullWebServices.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResourse {

    @Autowired
    private UserDaoService service;

    @GetMapping(path = "/users")
    public List<User> showUsers(){
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User spesificUser(@PathVariable int id){
        return service.findOne(id);
    }


    @PostMapping (path = "/users")
    public void createUser(@RequestBody User newUser){
        User savedUser=service.createUser(newUser);
    }

}
