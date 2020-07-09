package com.example.service;

import com.example.orm.User;

public interface UserService {
    User findByName(String username);
    void save(User user);
    void updatestate(String code);
}
