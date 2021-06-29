package com.secondProject.springboot.web.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean validateUser(String userName,String password){
        return userName.equalsIgnoreCase("real user") && password.equalsIgnoreCase("dummy");
    }
}
