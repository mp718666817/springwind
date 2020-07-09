package com.example.impl;

import com.example.dao.IUserDao;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
    @Override
    public List<User> findAll()  {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory session = builder.build(in);
        SqlSession sqlSession = session.openSession();
        List<User> list = sqlSession.selectList("com.example.dao.IUserDao.findAll");
        return list;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
