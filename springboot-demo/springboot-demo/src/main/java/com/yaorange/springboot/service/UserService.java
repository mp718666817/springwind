package com.yaorange.springboot.service;

import com.yaorange.springboot.dao.UserMapper;
import com.yaorange.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

//    (noRollbackFor = ArithmeticException.class)
    @Transactional
    public void save()
    {
        User user = new User();
        user.setName("德华");

        userMapper.insert(user);

        try{
            int i = 1/0;
        }catch (Exception e)
        {

        }


    }

    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
