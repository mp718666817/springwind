package com.example.service.impl;

import com.example.dao.Userdao;
import com.example.dao.impl.UserdaoImpl;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
    Userdao userdao = new UserdaoImpl();
    @Override
    public void saveService() {
        System.out.println("saveService");
        userdao.save();
    }
}
