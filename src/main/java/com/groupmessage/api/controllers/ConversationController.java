package com.groupmessage.api.controllers;

import com.groupmessage.api.controllers.exceptions.ConversationNotFoundException;
import com.groupmessage.api.controllers.interfaces.ConversationRepository;
import com.groupmessage.api.controllers.models.Conversation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ConversationController {
    private final ConversationRepository repository;
    private final ConversationModelAssembler assembler;

    public ConversationController(ConversationRepository repository, ConversationModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/messages")
    CollectionModel<EntityModel<Conversation>> all() {
        List<EntityModel<Conversation>> messages = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(messages, linkTo(methodOn(MessageController.class).all()).withSelfRel());
    }

    @GetMapping("/messages/{id}")
    EntityModel<Conversation> one(@PathVariable Long id) {
        Conversation conversation = repository.findById(id).orElseThrow(() -> new ConversationNotFoundException(id));
        return assembler.toModel(conversation);
    }
}
