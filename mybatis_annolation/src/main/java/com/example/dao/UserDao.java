package com.example.dao;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    /**
     * mybatis注解开发
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Insert("insert into user(username,address,sex,birthday) value(#{username},#{address},#{sex},#{birthday})")
    void inser(User user);

    void deleteUser(Integer in);
    @Select("select * from user where id=#{id}")
    User findByid(Integer i);

    void findByLike(String name);
}
