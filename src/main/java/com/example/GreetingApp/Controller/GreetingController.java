package com.example.GreetingApp.Controller;


import com.example.GreetingApp.Model.Greeting;
import com.example.GreetingApp.Model.User;
import com.example.GreetingApp.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // GET Request - Greeting with Query Parameters
    @GetMapping
    public Greeting getGreeting(@RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName) {
        User user = new User(firstName, lastName);
        return greetingService.getGreeting(user);
    }

    // POST Request - Greeting using Request Body
    @PostMapping
    public Greeting getGreetingFromBody(@RequestBody User user) {
        return greetingService.getGreeting(user);
    }
}
