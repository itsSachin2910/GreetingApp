package com.spring.RestAPI.customexception;


public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("User not found with id: " + id);
    }
}
