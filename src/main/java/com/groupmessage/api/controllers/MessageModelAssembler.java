package com.groupmessage.api.controllers;

import com.groupmessage.api.controllers.models.Message;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class MessageModelAssembler implements RepresentationModelAssembler<Message, EntityModel<Message>> {
    @Override
    public EntityModel<Message> toModel(Message message) {
        EntityModel<Message> messageModel = EntityModel.of(message,
                linkTo(methodOn(MessageController.class).one(message.getId())).withSelfRel(),
                linkTo(methodOn(MessageController.class).all()).withRel("messages"));

        return messageModel;
    }
}
