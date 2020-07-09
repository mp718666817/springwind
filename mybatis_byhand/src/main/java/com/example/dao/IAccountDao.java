package com.example.dao;

import com.example.domain.IAccount;

import java.util.List;

public interface IAccountDao {
    List<IAccount> findAll();
}
