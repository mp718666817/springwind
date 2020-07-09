package com.example.dao;

import com.example.domain.IAccount;
import com.example.domain.User;

import java.util.List;

public interface IAccountDao {
    List<IAccount> findAll();
    List<IAccount> findById(Integer id);
}
