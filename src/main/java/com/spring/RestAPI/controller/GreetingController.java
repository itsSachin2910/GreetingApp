package com.spring.RestAPI.controller;

import com.spring.RestAPI.model.Greeting;
import com.spring.RestAPI.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Create Greeting
    @PostMapping
    public Greeting createGreeting(@RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName) {
        return greetingService.createGreeting(firstName, lastName);
    }

    // Get Greeting by ID
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }


}
