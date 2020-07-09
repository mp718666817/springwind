package com.example.springserviceprovider.service;

import com.example.springserviceprovider.mapper.UserMapper;
import com.example.springserviceprovider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User queruyUserById(Integer id){
        System.out.println(this.userMapper.selectByPrimaryKey(1));
        return this.userMapper.selectByPrimaryKey(id);
    }
}
