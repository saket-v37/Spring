package com.springBooot.restfullWebServices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    // empty constructor
    public Post() {
    }

    // args constructor
    public Post(int id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user=user;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    // toString method
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
