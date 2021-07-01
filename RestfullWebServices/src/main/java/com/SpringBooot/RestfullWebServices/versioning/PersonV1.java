package com.springBooot.restfullWebServices.versioning;

public class PersonV1 {
    // fields
    private String name;


    //  default constructor
    public PersonV1(){}
    //  constructor with args
    public PersonV1(String name) {
        this.name = name;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
