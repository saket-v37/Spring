package com.springBooot.restfullWebServices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@ApiModel(description="All details about the user.") // for swagger api documentation
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2,message = "Add more than 2 character")
    @ApiModelProperty(notes="Name should have at least 2 characters") // for swagger api documentation
    private  String name;

    @Past(message = "Date should be from past")
    @ApiModelProperty(notes="Birth date should be in the past") // for swagger api documentation
    private LocalDate dob;


    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    // empty constructor
    public User() {
    }
    // args constructor
    public User(Integer id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Post> getPosts() {
        return posts;
    }


    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}

