package com.springBooot.restfullWebServices.filtering;


/*
    NOTE: Static Filter:----
    -> You can filter fields in 2 ways :-
        * either use @JsonIgnore on each particular field which you want to exclude. {Recommended}
        * Define all fields which you want to exclude at once, By adding @JsonIgnoreProperties annotation in your class
 */


import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value={"field1","field2"})
// Not recommended, because {it is hard codded}-- in future if do change on your bean/class or fields you also have to change it here.
@JsonFilter("SomeBeanFilter") // Dynamic filter
public class SomeBean {
    // fields
    private String field1;
    // @JsonIgnore -- Commenting because using dynamic filter
    private String field2;
   // @JsonIgnore -- Commenting because using dynamic filter
    private String field3;


    //constructor
    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }


    // getters and setters
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}
