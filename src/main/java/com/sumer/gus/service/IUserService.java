package com.sumer.gus.service;

import com.sumer.gus.pojos.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    boolean validateUser(String email, String password);
}
