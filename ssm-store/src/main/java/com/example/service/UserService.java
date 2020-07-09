package com.example.service;

import com.example.entity.User;

public interface UserService {
    /**
     * 查找所有用户
     * @return
     */
    User findUserAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 修改用户状态
     * @param code
     * @return
     */
    int updateState(String code);

    /**
     * 判断用户登录的代码
     * @param username
     * @param password
     * @return
     */
    boolean login(String username,String password);

    /**
     * 注册用户的服务
     * @param user
     * @return
     */
    boolean register(User user);
}
