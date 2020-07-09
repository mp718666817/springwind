package com.example.dao;

import com.example.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    @Select("select * from account")
    @Results(id="resultmap",
            value = {@Result(id = true, property = "id", column = "id"),
                    @Result(property = "money", column = "money"),
                    @Result(property = "user",column = "uid",one = @One(select="com.example.dao.UserDao.findByid",
                            fetchType=FetchType.EAGER))
            }
    )
    List<Account> findAll();
}
