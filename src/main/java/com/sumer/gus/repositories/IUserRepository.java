package com.sumer.gus.repositories;

import com.sumer.gus.pojos.User;

import java.util.List;

public interface IUserRepository {
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(Long id);
}
