package com.example.dao;

import com.example.domain.Account;

public interface IAccountDao {
    /**
     * 根据姓名查询
     * @param accountName
     * @return
     */
    Account findByName(int accountName);

    /**
     * 根据id查询
     * @param accountId
     * @return
     */
    Account findById(int accountId);

    void update(Account account);

}
