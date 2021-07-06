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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path = "/jpa/users")
public class UserJPAController {

    @Autowired
    private UserJPAService userJPAService;

    @Autowired
    private PostJPAService postJPAService;

    private UserNotFoundException userNotFoundException;



    // Display all users
    @GetMapping()
    public List<User> showAllUsers(){
        return userJPAService.findAll();
    }



    // Find user
    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userJPAService.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id-"+ id);

        // HATEOAS:-
        // it used when you want to add additional links to your current link's response.
        // Like: if want to show link of getting "all users", when user clink on the link of finding particular user.
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).showAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }



    // Create new user
    @PostMapping()
    public ResponseEntity<Object> createUser(@Valid @RequestBody User newUser){
        User savedUser= userJPAService.save(newUser);

        // returning back the URI(Location or path of created user)
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build(); // ** Important
    }



   // Delete user
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id){
        userJPAService.deleteById(id);

        // TODO: implement exception(if user is null)
    }


    // Find all user posts
    // Find user
    @GetMapping("/{id}/posts")
    public List<Post> retrievePosts(@PathVariable int id) {
        Optional<User> user = userJPAService.findById(id);

        if(user.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }

        return user.get().getPosts();
    }


    @PostMapping("/{id}/posts")
    public ResponseEntity<Object> createPosts(@PathVariable int id, @RequestBody Post post) {
        Optional<User> userOptional = userJPAService.findById(id);


        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }

        User user=userOptional.get();
        post.setUser(user);
        postJPAService.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
