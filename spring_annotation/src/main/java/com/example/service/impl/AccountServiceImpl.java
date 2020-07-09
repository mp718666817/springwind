package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service(value = "accountservice")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        return iAccountDao.findAll();
    }

    @Override
    public Account findById(int id) throws SQLException {
        return iAccountDao.findById(id);
    }

    @Override
    public void update(Account account) throws SQLException {
        iAccountDao.update(account);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        iAccountDao.delete(id);
    }
}
