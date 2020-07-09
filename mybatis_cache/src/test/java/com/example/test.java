package com.example;

import com.example.dao.IAccountDao;
import com.example.dao.IUserDao;
import com.example.domain.IAccount;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
    }
    private SqlSession session;
    private InputStream in;
    private IUserDao mapper;
    private SqlSessionFactory factory;
    private IAccountDao iAccountDao;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        mapper = session.getMapper(IUserDao.class);
        //iAccountDao = session.getMapper(IAccountDao.class);
    }

    public void destroy() throws IOException {
        session.commit();
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void iAccount(){
      // iAccountDao.findAll();
//        System.out.println(all);
    /*    List<User> all = mapper.findAll();
        System.out.println(all);
        for (User user : all) {
            System.out.println(user.getAccount());
        }*/
        User byId = mapper.findById(48);
        System.out.println(byId);
        session.commit();
        session.close();
        session = factory.openSession();
        mapper = session.getMapper(IUserDao.class);
        User byId2 = this.mapper.findById(48);
        System.out.println(byId==byId2);

        System.out.println(byId2);
    }
    /**
     * 测试缓存同步
     */
    @Test
    public void testClearCache(){
        User user1 = mapper.findById(48);
        System.out.println(user1);
        User u = new User();
        u.setUsername("update user clear cache");
        u.setAddress("djfklsd@qq.com");
        mapper.update(u);
        User user = mapper.findById(48);
        System.out.println(user);
        System.out.println(user1==user);
    }
    /**
     *
     * 二级缓存测试
     */
    @Test
    public void test_2_cache(){

    }
}
