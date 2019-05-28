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
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {
  @Autowired private UserDaoService userDaoService;

  @Autowired private UserRepository userRepository;

  @Autowired private TweetsRepository tweetsRepository;

  @GetMapping(path = "/jpa/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping(path = "/jpa/user/{id}")
  public Resource<User> getUser(@PathVariable int id) {
    Optional<User> user = userRepository.findById(id);

    // add link to display all user using hateoas
    Resource<User> userResource = new Resource<>(user.get());

    ControllerLinkBuilder linkToAllUsers = linkTo(methodOn(this.getClass()).getAllUsers());

    userResource.add(linkToAllUsers.withRel("all-users"));

    // HATEOAS
    return userResource;
  }

  @PostMapping(path = "/jpa/adduser")
  public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

    // this will respond with status code 201 instead of 200
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping(path = "/jpa/deleteUser/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }

  @GetMapping(path = "/jpa/users/{id}/tweets")
  public List<Tweets> retrieveAllUsers(@PathVariable int id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (!optionalUser.isPresent()) throw new UserNotFoundException("id-" + id);
    return optionalUser.get().getTweetsList();
  }

  @PostMapping(path = "/jpa/users/{id}/tweet")
  public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Tweets tweets) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (!optionalUser.isPresent()) throw new UserNotFoundException("id-" + id);

    User user = optionalUser.get();
    tweets.setUser(user);

    tweetsRepository.save(tweets);

    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(tweets.getId())
            .toUri();

    // this will respond with status code 201 instead of 200
    return ResponseEntity.created(location).build();
  }
}
