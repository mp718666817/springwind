package com.example.springbootmybatisplugins;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybatisplugins.mapper")
public class SpringbootMybatispluginsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatispluginsApplication.class, args);
    }

}
