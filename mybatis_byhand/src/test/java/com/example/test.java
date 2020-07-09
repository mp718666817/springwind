package com.example;

import com.example.dao.IAccountDao;
import com.example.dao.IUserDao;
import com.example.domain.IAccount;
import com.example.domain.QueryVo;
import com.example.domain.User;
import com.example.impl.IUserDaoImpl;
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
    private IAccountDao iAccountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        //mapper = session.getMapper(IUserDao.class);
        iAccountDao = session.getMapper(IAccountDao.class);
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
    public void test() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
    /*    List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }*/
        User user = new User();
        user.setAddress("12323");
        user.setBirthday(new Date());
        user.setSex('男');
        user.setUsername("moche");
        System.out.println(user);
        mapper.saveUser(user);
        System.out.println(user);
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
    @Test
    public void deteleUser(){
        mapper.deteleUser(50);
    }
    @Test
    public void findByName(){
        List<User> byName = mapper.findByName("%王%");
        System.out.println(byName);
    }
    @Test
    public void test1() throws IOException {
        IUserDaoImpl iUserDao = new IUserDaoImpl();
        List<User> all = iUserDao.findAll();
        System.out.println(all);
    }
    @Test
    public void saveData(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setAddress("123@1223");
        user.setBirthday(new Date());
        user.setSex('男');
        user.setUsername("dfddfdfds");
        queryVo.setUser(user);
        mapper.savaData(queryVo);
    }
    @Test
    public void iAccount(){
        List<IAccount> all = iAccountDao.findAll();
        System.out.println(all);
    }
}
