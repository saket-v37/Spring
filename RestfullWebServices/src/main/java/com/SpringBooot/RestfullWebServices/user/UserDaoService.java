package com.springBooot.restfullWebServices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
// @Repository {used only when database will added}
public class UserDaoService {

    private static List<User> users=new ArrayList<>();
    private static int userCount=3;

    static {
        users.add(new User(1,"Jayant Singh",LocalDate.of(1995, Month.AUGUST,25)));
        users.add(new User(2,"Abhishek Sharma",LocalDate.of(1997, Month.JANUARY,5)));
        users.add(new User(3,"Anil Kumar",LocalDate.of(1992, Month.DECEMBER,25)));
    }

    // implement these findAll,save ,findOne
    public  List<User> findAll(){
        return users;
    }

    public User createUser(User newUser){
        if (newUser.getId()==null){
            newUser.setId(++userCount);
        }
        users.add(newUser);
        return newUser;
    }

    public User findOne(int id){
        for(User user:users){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }


}
