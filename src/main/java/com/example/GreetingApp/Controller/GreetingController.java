package com.example.GreetingApp.Controller;

import com.example.GreetingApp.Model.Greeting;
import com.example.GreetingApp.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // GET Request - Retrieve "Hello World"
    @GetMapping
    public Greeting getSimpleGreeting() {
        return greetingService.getGreeting();
    }
}
