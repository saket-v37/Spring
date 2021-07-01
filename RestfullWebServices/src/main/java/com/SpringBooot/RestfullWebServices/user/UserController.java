package com.springBooot.restfullWebServices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService service;
    private UserNotFoundException userNotFoundException;



    // Display all users
    @GetMapping()
    public List<User> showAllUsers(){
        return service.findAll();
    }



    // Find user
    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findById(id);
        if(user==null)
            throw new UserNotFoundException("id-"+ id);

        // HATEOAS:-
        // it used when you want to add additional links to your current link's response.
        // Like: if want to show link of getting all users, when user clink on the link of finding particular user.
        EntityModel<User> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).showAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }



    // Create new user
    @PostMapping ()
    public ResponseEntity<Object> createUser(@Valid @RequestBody User newUser){
        User savedUser=service.createUser(newUser);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build(); // ** Important
    }



    // Delete user
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id){
        User user= service.deleteById(id);

        if (user==null){
            throw new UserNotFoundException("id:"+id);
        }
    }
}
