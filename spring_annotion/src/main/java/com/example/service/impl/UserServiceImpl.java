package com.example.service.impl;

import com.example.dao.Userdao;
import com.example.dao.impl.UserdaoImpl;
import com.example.service.UserService;
import org.springframework.stereotype.Component;

@Component(value = "userService")
public class UserServiceImpl implements UserService {
    Userdao userdao = new UserdaoImpl();

    public UserServiceImpl() {
        System.out.println("UserServiceImpl创建了");
    }

    @Override
    public void saveService() {
        System.out.println("saveService");
        userdao.save();
    }
}
