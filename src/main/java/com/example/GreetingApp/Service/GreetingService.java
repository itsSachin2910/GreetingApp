package com.example.GreetingApp.Service;



import com.example.GreetingApp.Model.Greeting;

import java.util.List;

public interface GreetingService {
    Greeting saveGreeting(String message);
    List<Greeting> getAllGreetings();
}

