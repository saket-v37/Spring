package com.secondProject.springboot.web.controller;

import com.secondProject.springboot.web.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    LoginService service;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showloginPage(){
        return "loginForm";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model,@RequestParam String name,@RequestParam String password){
        boolean isValidUser=service.validateUser(name,password);
        if(!isValidUser) {
            return "loginForm";
            //model.put("message", "Invalid Credentials"); -- error--not running??
        }
        else {
            model.put("name", name);
            return "welcomePage";
        }
    }
}
