package com.example.dao.impl;

import com.example.dao.IAccountDao;
import com.example.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    QueryRunner runner;

    public AccountDaoImpl(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
    }

    @Override
    public Account findById(int id) throws SQLException {
        return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),id);
    }

    @Override
    public void update(Account account) throws SQLException {
        runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),
                account.getId());
    }

    @Override
    public void delete(Integer id) throws SQLException {
        runner.update("delete from account where id=?",id);
    }
}
