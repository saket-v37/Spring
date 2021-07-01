package com.springBooot.restfullWebServices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@ApiModel(description="All details about the user.") // for swagger api documentation
public class User {
    private Integer id;

    @Size(min = 2,message = "Add more than 2 character")
    @ApiModelProperty(notes="Name should have at least 2 characters") // for swagger api documentation
    private  String name;

    @Past(message = "Date should be from past")
    @ApiModelProperty(notes="Birth date should be in the past") // for swagger api documentation
    private LocalDate dob;

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

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}

