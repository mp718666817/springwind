package com.example.dao;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test1 {
    SqlSessionFactory factory;
    InputStream in;
    SqlSession sqlSession;
    UserDao userDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void test(){
        /*List<User> all = userDao.findAll();
        System.out.println(all);*/
        User user = new User();
        user.setId(49);
        user.setAddress("德阳");
        user.setUsername("摩擦");
        user.setBirthday(new Date());
        user.setSex('男');
        userDao.updateUser(user);
    }
    @Test
    public void findById(){
        User user = userDao.findByid(49);
        System.out.println(user);
    }
}
