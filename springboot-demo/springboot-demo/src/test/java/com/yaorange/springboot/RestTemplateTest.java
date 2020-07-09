package com.yaorange.springboot;

import com.yaorange.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void test(){
        User user = restTemplate.getForObject("http://localhost:8888/hello", User.class);
        System.out.println(user);
    }
}
