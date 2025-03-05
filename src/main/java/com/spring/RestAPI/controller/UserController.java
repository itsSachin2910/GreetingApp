package com.spring.RestAPI.controller;



import com.spring.RestAPI.dto.AuthUserDTO;
import com.spring.RestAPI.model.AuthUser;
import com.spring.RestAPI.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<List<AuthUser>> getAllUsers() {
        List<AuthUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<AuthUser> getUserById(@PathVariable Long id) {
        AuthUser user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/add")
    public ResponseEntity<AuthUser> addUser(@Valid @RequestBody AuthUserDTO userDTO) {
        AuthUser user = new AuthUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        AuthUser savedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    @PutMapping("/id/{id}")
    public ResponseEntity<AuthUser> updateUser(@PathVariable Long id, @Valid @RequestBody AuthUserDTO userDTO) {
        AuthUser user = new AuthUser();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        AuthUser updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
        return ResponseEntity.noContent().build();
    }
}

