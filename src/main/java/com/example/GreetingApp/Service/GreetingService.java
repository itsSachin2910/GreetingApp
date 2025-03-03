package com.example.GreetingApp.Service;


import com.example.GreetingApp.Model.Greeting;
import com.example.GreetingApp.Model.User;

public interface GreetingService {
    Greeting getGreeting(User user);
}
