package com.example.webservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.webservice.exception.UserNotFoundException;

@RestController
public class UserResource {
    private UserDAOService service;

    public UserResource(UserDAOService service){
        this.service=service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.removeById(id);
    }

    @GetMapping(path ="/users/{id}")
    public EntityModel <User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: "+id);
        }
        //Wrap User resource in EntityModel
        EntityModel<User> entityModel=EntityModel.of(user);
        //Create a link to point retrieveAllUsers controller method
        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        //Add link to entity model
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping(path="/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User userSaved =service.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(userSaved.getId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

}
