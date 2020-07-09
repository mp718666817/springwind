package com.example.dao;

import com.example.orm.User;

public interface UserDao {
    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    User findByName(String username);

    /**
     * 保存用户
     * @param user
     */
    void  save(User user);

    /**
     * 修改用户状态
     * @param code 激活码
     * @return
     */
    int updatestate(String code);

}
