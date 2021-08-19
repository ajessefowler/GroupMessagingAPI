package com.groupmessage.api.controllers.advice;

import com.groupmessage.api.controllers.exceptions.ConversationNotFoundException;
import com.groupmessage.api.controllers.models.Conversation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConversationNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ConversationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String messageNotFoundHandler(ConversationNotFoundException ex) { return ex.getMessage(); }
}
