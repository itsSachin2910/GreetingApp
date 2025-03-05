package com.spring.RestAPI.service;

import com.spring.RestAPI.model.Greeting;
import com.spring.RestAPI.model.AuthUser;

import java.util.List;

public interface IGreetingService {

    List<Greeting> getAll();
    Greeting addGreeting(AuthUser user);
    Greeting getGreetingById(long id);
    Greeting updateGreetingById(Long id, Greeting updatedGreeting);
    void removeGreetingById(Long id);
    String sayHello();
}
