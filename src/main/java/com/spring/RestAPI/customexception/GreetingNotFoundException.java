package com.spring.RestAPI.customexception;


public class GreetingNotFoundException extends RuntimeException {
    public GreetingNotFoundException(Long id) {
        super("Greeting not found with id: " + id);
    }
}
