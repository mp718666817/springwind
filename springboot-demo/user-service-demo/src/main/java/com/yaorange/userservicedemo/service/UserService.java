package com.yaorange.userservicedemo.service;

import com.yaorange.userservicedemo.dao.UserMapper;
import com.yaorange.userservicedemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}