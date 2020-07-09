package com.example.springservicecomsumer.controller;

import com.example.springservicecomsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("comsumer/user")
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/{id}")
    public User queuryById(@PathVariable("id") Integer id)
    {

        List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");


        ServiceInstance instance = instances.get(0);
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
        System.out.println(baseUrl);
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        System.out.println(user);
        return user;
    }
}
