package com.example.springbootmybatisplugins;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplugins.mapper.UserMapper;
import com.example.springbootmybatisplugins.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootMybatispluginsApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println );
    }
    @Test
    void pages(){
        Page<User> page = new Page<>(0,2);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal() );
    }
    @Test
    void testOptimistic(){
        User user = userMapper.selectById(1L);
        user.setEmail("13434@163.com");
        user.setName("张三");
        user.setBirthday(new Date());
        user.setPwd("123456");
        userMapper.updateById(user);
    }
    @Test
    void testOptimistcFailed(){
        User user = userMapper.selectById(1L);
        user.setEmail("13434@163.com");
        user.setName("张三");
        user.setBirthday(new Date());
        user.setPwd("123456");
        User user1=userMapper.selectById(1L);
        user1.setEmail("99334@163.com");
        user1.setName("张si");
        user1.setBirthday(new Date());
        user1.setPwd("12343");
        userMapper.updateById(user1);

        userMapper.updateById(user);

    }
    @Test
    void insertTest(){
        User user = new User();
        user.setEmail("23ddfs@163.com");
        user.setName("李三");
        user.setBirthday(new Date());
        user.setPwd("384932");
        userMapper.insert(user);
    }
    @Test
    void deleteSomes(){
       // userMapper.deleteBatchIds(Arrays.asList(6L,7,8));
        userMapper.deleteById(1);
    }
    @Test
    void generateCode(){

    }

}
