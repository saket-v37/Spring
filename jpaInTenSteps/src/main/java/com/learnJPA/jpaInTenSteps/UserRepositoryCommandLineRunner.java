package com.learnJPA.jpaInTenSteps;

import com.learnJPA.jpaInTenSteps.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


// Use to add user at command line (when our project is starting)
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log= LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // save or add user
        User user2=new User("Mathew","User");
        userRepository.save(user2);
        log.info("New User is created and details are as follows"+user2);

        // find or search user
        Optional<User> userWithIdOne=userRepository.findById(1L);
        log.info("User retrieved :"+userWithIdOne);

        // display all users
        List<User> allUser=userRepository.findAll();
        log.info("list of all users:"+allUser);
    }
}
