package com.example.GreetingApp.Service;


import com.example.GreetingApp.Model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting getGreeting() {
        return new Greeting("Hello World");
    }
}

