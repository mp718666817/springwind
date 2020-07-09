package com.yaorange.userconsumerdemo.dao;

import com.yaorange.userconsumerdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public User queryUserById(Long id){

//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        ServiceInstance serviceInstance = instances.get(0);
//
//
////        String url = "http://localhost:8081/user/" + id;
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id;
        String url = "http://user-service/user/" + id;
        return this.restTemplate.getForObject(url, User.class);
    }
}