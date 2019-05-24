package com.venkyms.rest.webservices.resfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserResource {
  @Autowired private UserDaoService userDaoService;

  @GetMapping(path = "/users")
  public List<User> getAllUsers() {
    return userDaoService.findAll();
  }

  @GetMapping(path = "/user/{id}")
  public Resource<User> getUser(@PathVariable int id) {
    User user = userDaoService.findOne(id);

    //add link to display all user using hateoas
    Resource<User> userResource = new Resource<>(user);

    ControllerLinkBuilder linkToAllUsers = linkTo(methodOn(this.getClass()).getAllUsers());

    userResource.add(linkToAllUsers.withRel("all-users"));

    //HATEOAS
    return userResource;

  }

  @PostMapping(path = "/adduser")
  public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
    User savedUser = userDaoService.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

    // this will respond with status code 201 instead of 200
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping(path = "deleteUser/{id}")
  public void deleteUser(@PathVariable int id) {
    if (!userDaoService.deleteById(id)) throw new UserNotFoundException("id missing");
  }
}
