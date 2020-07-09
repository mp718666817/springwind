package com.example.service.impl;

import com.example.dao.Userdao;
import com.example.dao.impl.UserdaoImpl;
import com.example.service.UserService;

import java.util.Date;

public class UserServiceImpl implements UserService {
    String name;
    String password;
    Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

/*    public UserServiceImpl(String name, String password, Date birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }*/

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public void saveService() {
    }
}
