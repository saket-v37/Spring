package com.springBooot.restfullWebServices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // without creating bean
    @GetMapping(path = "/hello-world")
    public String sayHello(){
        return "Hello World!";
    }
    // with Bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World!");
    }

    // adding Path-variable without using bean
    @GetMapping(path = "/hello-world/{name}")
    public String sayHelloWithPathVariable(@PathVariable String name){
        return "Hello, "+name;
    }
    // adding Path-variable in Bean
    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldUsingPathVariable (@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));
    }


}
