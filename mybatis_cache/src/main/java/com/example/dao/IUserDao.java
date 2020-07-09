package com.example.dao;

import com.example.domain.User;

import java.util.List;

public interface IUserDao {
    User findById(Integer id);
    List<User> findAll();
    void update(User user);
}
