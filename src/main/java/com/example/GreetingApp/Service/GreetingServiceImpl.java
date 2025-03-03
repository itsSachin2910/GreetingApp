package com.example.GreetingApp.Service;

import com.example.GreetingApp.Model.Greeting;
import com.example.GreetingApp.Model.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public Greeting getGreeting(User user) {
        if (user.getFirstName() != null && user.getLastName() != null) {
            return new Greeting("Hello, " + user.getFirstName() + " " + user.getLastName() + "!");
        } else if (user.getFirstName() != null) {
            return new Greeting("Hello, " + user.getFirstName() + "!");
        } else if (user.getLastName() != null) {
            return new Greeting("Hello, " + user.getLastName() + "!");
        } else {
            return new Greeting("Hello World!");
        }
    }
}
