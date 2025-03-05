package com.spring.RestAPI.service;


import com.spring.RestAPI.customexception.UserNotFoundException;
import com.spring.RestAPI.model.AuthUser;
import com.spring.RestAPI.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService{

    @Autowired
    private AuthUserRepository userRepository;

    public UserService() {
        super();
    }

    @Override
    public List<AuthUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AuthUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public AuthUser addUser(AuthUser user) {
        return userRepository.save(user);
    }

    @Override
    public AuthUser updateUser(Long id, AuthUser user) {
        AuthUser userInDb = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        userInDb.setLastName(user.getLastName());
        userInDb.setFirstName(user.getFirstName());
        return userRepository.save(userInDb);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
        return;
    }


}
