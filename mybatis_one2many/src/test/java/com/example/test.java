package com.example;

import com.example.dao.IUserDao;
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

public class test {
    public static void main(String[] args) throws IOException {
    }
    private SqlSession session;
    private InputStream in;
    private IUserDao mapper;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        mapper = session.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findall() throws IOException {
        List<User> all = mapper.findAll();
        System.out.println(all);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(50);
        user.setAddress("123@12323");
        user.setBirthday(new Date());
        user.setSex('男');
        user.setUsername("dfds");
        mapper.updateUser(user);

    }
}
