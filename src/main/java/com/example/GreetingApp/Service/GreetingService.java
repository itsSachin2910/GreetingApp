package com.example.GreetingApp.Service;


import com.example.GreetingApp.Model.Greeting;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    private final AtomicLong counter = new AtomicLong();

    public Greeting getGreeting(String name) {
        return new Greeting(counter.incrementAndGet(), "Hello, " + name + "!");
    }
}

