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

    // GET Request - Retrieve a greeting
    @GetMapping("/{name}")
    public Greeting getGreeting(@PathVariable String name) {
        return greetingService.getGreeting(name);
    }

    // POST Request - Create a new greeting
    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting(greeting.getId(), "Received: " + greeting.getMessage());
    }

    // PUT Request - Update a greeting
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable long id, @RequestBody Greeting greeting) {
        return new Greeting(id, "Updated: " + greeting.getMessage());
    }

    // DELETE Request - Delete a greeting
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable long id) {
        return "Greeting with ID " + id + " deleted.";
    }
}
