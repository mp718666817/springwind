package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.orm.User;
import com.example.service.UserService;
import com.example.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    @Override
    public User findByName(String username) {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.findByName(username);
        return user;
    }

    @Override
    public void save(User user) {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.save(user);
    }

    @Override
    public void updatestate(String code) {
        SqlSessionFactory sessionFactory = MybatisUtil.getSessionFactory();
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updatestate(code);
    }
}
