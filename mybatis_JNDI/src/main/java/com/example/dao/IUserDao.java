package com.example.dao;

import com.example.domain.User;

import java.io.IOException;
import java.util.List;

public interface IUserDao {
    List<User> findAll() throws IOException;
    void saveUser(User user);
    void updateUser(User user, int i);

    void updateUser(User user);
    void deteleUser(int id);
    List<User> findByName(String name);
}
