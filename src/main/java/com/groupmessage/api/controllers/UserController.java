package com.groupmessage.api.controllers;

import com.groupmessage.api.auth.interfaces.UserRepository;
import com.groupmessage.api.auth.models.User;
import com.groupmessage.api.controllers.exceptions.UserNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) { this.repository = repository; }

    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all() {
        List<EntityModel<User>> users = repository.findAll().stream()
                .map(user -> EntityModel.of(user,
                        linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
                        linkTo(methodOn(UserController.class).all()).withRel("users")))
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @GetMapping("/users/{id}")
    EntityModel<User> one(@PathVariable Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("users"));
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) { return repository.save(newUser); }

    // TODO - put and delete mappings
}
