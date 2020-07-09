package com.example.springboot.service;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserService {
    @Mapper
    List<User> findAll();
}
