package com.example.springmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ywh.**.dao")
public class SpringMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisPlusApplication.class, args);
    }

}
