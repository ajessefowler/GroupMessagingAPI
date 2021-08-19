package com.groupmessage.api.controllers;

import com.groupmessage.api.controllers.models.Conversation;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ConversationModelAssembler implements RepresentationModelAssembler<Conversation, EntityModel<Conversation>> {
    @Override
    public EntityModel<Conversation> toModel(Conversation conversation) {
        return EntityModel.of(conversation,
                linkTo(methodOn(ConversationController.class).one(conversation.getId())).withSelfRel(),
                linkTo(methodOn(ConversationController.class).all()).withRel("conversations"));
    }
}
