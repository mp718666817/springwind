package com.example.springboot1.config;

import com.example.springboot1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServiceConfig {
    @Bean
    public UserService getUserSvice(){
        System.out.println("将组建放入容器中。");
        return new UserService();
    }
}
