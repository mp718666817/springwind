package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.MailUtils;
import com.example.util.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findUserAll() {
        return userDao.findUserAll();
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public int updateState(String code) {
        return userDao.updateState(code);
    }

    @Override
    public boolean login(String username, String password) {
        try {
            System.out.println(findByName(username));
            if (findByName(username) != null) {
                if (password.equals(findByName(username).getPassword())) {
                    System.out.println("登录成功");
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        //注册是否成功的标识
        boolean result = false;
        try {
            //新用户的某些属性(uid, state,code)是代码生成的
            user.setUid(UuidUtils.getUUID());
            user.setState(0); //"未激活"
            user.setCode(UuidUtils.getUUID());

            userDao.save(user);

            //注册业务返回之前, 发送激活邮件到用户注册时留下的邮箱
            //todo 注册业务返回之前, 发送激活邮件到用户注册时留下的邮箱
            MailUtils.sendMail(user.getEmail(), user.getCode());

            result = true;
        }
        finally {
            return result;
        }
    }

}
