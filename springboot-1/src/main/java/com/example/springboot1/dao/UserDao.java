package com.example.springboot1.dao;

import com.example.springboot1.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from account")
    List<Account> findAll();
}
