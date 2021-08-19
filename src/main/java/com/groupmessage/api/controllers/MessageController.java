package com.groupmessage.api.controllers;

import com.groupmessage.api.controllers.exceptions.MessageNotFoundException;
import com.groupmessage.api.controllers.interfaces.MessageRepository;
import com.groupmessage.api.controllers.models.Message;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class MessageController {
    private final MessageRepository repository;
    private final MessageModelAssembler assembler;

    public MessageController(MessageRepository repository, MessageModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/messages")
    CollectionModel<EntityModel<Message>> all() {
        List<EntityModel<Message>> messages = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(messages, linkTo(methodOn(MessageController.class).all()).withSelfRel());
    }

    @GetMapping("/messages/{id}")
    EntityModel<Message> one(@PathVariable Long id) {
        Message message = repository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
        return assembler.toModel(message);
    }

    @PostMapping("/messages")
    ResponseEntity<EntityModel<Message>> newMessage(@RequestBody Message message) {
        Message newMessage = repository.save(message);
        return ResponseEntity
                .created(linkTo(methodOn(MessageController.class).one(newMessage.getId())).toUri())
                .body(assembler.toModel(newMessage));
    }
}
