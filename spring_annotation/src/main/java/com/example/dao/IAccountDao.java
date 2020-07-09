package com.example.dao;

import com.example.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有数据
     * @return
     */
    List<Account> findAll() throws SQLException;

    /**
     * 根据id查询Account
     * @return
     */
    Account findById(int id) throws SQLException;

    /**
     * 更新数据库
     * @param account
     */
    void update(Account account) throws SQLException;

    /**
     * 根据id删除数据
     * @param id
     */
    void delete(Integer id) throws SQLException;
}
