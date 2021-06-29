package com.springApplication.Todo.controller;

import com.springApplication.Todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos",method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        model.put("todos",service.retrieveTodos("Jordan"));
        return "list-todos";
    }

}