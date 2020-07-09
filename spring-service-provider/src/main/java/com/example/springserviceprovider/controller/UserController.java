package com.example.springserviceprovider.controller;

import com.example.springserviceprovider.pojo.User;
import com.example.springserviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return this.userService.queruyUserById(id);
    }
}
