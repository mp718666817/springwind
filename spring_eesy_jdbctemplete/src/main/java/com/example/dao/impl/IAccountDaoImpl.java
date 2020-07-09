package com.example.dao.impl;

import com.example.dao.IAccountDao;
import com.example.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class IAccountDaoImpl extends JdbcDaoTemplete implements IAccountDao {
    @Override
    public Account findByName(int accountName) {
        List<Account> accounts = super.getTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if (accounts.isEmpty())
        {
            return null;
        }
        else if(accounts.size()>1){
            throw new RuntimeException("结果集异常");
        }
        return accounts.get(0);
    }

    @Override
    public Account findById(int accountId) {
        List<Account> accounts = super.getTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return  accounts.isEmpty()?null: accounts.get(0);
    }

    @Override
    public void update(Account account) {
        super.getTemplate().update("update account set name=?,money=? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
