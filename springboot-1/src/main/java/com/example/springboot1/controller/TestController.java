package com.example.springboot1.controller;

import com.example.springboot1.dao.UserDao;
import com.example.springboot1.domain.Account;
import com.example.springboot1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@EnableAutoConfiguration
public class TestController {
    @Autowired
    Person person;
    @Autowired
    UserDao userDao;
    @RequestMapping("/hello")
    public List<Account> test(){
        System.out.println(person);
        return userDao.findAll();
    }
}
