package com.example.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controll2")
public class UserController2 {
    @GetMapping("show")
    public String show(){
        return "spring boot 2";
    }

}
