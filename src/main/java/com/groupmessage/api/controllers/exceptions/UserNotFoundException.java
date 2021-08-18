package com.groupmessage.api.controllers.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) { super("Could not find user " + id); }
}
