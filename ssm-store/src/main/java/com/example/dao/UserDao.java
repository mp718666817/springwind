package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user")
    User findUserAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    User findByName(String username);

    /**
     * 修改用户状态
     * @param code
     * @return
     */
    @Update("update user set code=replace(a,0,1) ")
    int updateState(String code);

    /**
     * 保存用户的代码
     * @param user
     */
    @Insert("insert into user(uid,username,password,name,email,telephone,birthday,sex,state,code) values(#{uid}, #{username},#{password}, #{name}, #{email},#{telephone},#{birthday}, #{sex},#{state}, #{code})")
    void save(User user);
}
