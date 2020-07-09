package com.example.springboot1;

import com.example.springboot1.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class Springboot1ApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    ApplicationContext ioc;
    @Test
    void contextLoads() {
        boolean b = ioc.containsBean("getUserSvice");
        System.out.println(b);
    }

}
