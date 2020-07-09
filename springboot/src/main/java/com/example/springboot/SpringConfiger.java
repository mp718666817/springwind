package com.example.springboot;

import com.example.springboot.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
@EnableAutoConfiguration
public class SpringConfiger {
    public static void main(String[] args) {
        SpringApplication.run(SpringConfiger.class,args);
    }
}
