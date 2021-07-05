package com.learnJPA.jpaInTenSteps;

import com.learnJPA.jpaInTenSteps.entity.User;
import com.learnJPA.jpaInTenSteps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// Use to add user at command line (when our project is starting)
@Component
public class UserServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log= LoggerFactory.getLogger(UserServiceCommandLineRunner.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1=new User("Jacob","Admin");
        long id1=userService.insertUser(user1);
        log.info("New User is created with id:"+id1+"and details are as follows"+user1);


    }
}
