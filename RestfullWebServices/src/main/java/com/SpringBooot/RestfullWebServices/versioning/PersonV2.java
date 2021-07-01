package com.springBooot.restfullWebServices.versioning;


public class PersonV2 {

    // fields
    private Name name;

    //  default constructor
    public PersonV2(){}

    //  constructor with args
    public PersonV2(Name name) {
        this.name = name;
    }

    // Getters and Setters
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
}
