package com.spring.RestAPI.service;


import com.spring.RestAPI.model.AuthUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<AuthUser> getAllUsers();
    AuthUser getUserById(Long id);
    AuthUser addUser(AuthUser user);
    AuthUser updateUser(Long id,AuthUser user);
    void removeUser(Long id);

}
