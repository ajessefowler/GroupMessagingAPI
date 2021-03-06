package com.groupmessage.api.controllers.exceptions;

public class ConversationNotFoundException extends RuntimeException {
    public ConversationNotFoundException(Long id) { super("Could not find conversation " + id); }
}
