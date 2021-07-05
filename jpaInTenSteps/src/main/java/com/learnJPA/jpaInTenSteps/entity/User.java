package com.learnJPA.jpaInTenSteps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// mapped this bean to table called User
@Entity
public class User {

    // fields
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String role;

    // default constructor
    public User(){

    }

    // arguments constructor
    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    //getters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }


    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
