package dao;

import java.sql.SQLException;

import domain.User;

public interface UserDao {
	/**
	 * 
	 * @param user 根据用户名密码到数据库查询
	 * @return	如果User为null则表示没有记录 没有登录成功
	 * @throws SQLException
	 */
	User FindByNameAndPwd(User user) throws SQLException;
	/**
	 * 
	 * @param user 根据给定的用户对数据库进行插入操作
	 * @return 如果true则表示没有记录false 没有登录成功
	 * @throws SQLException
	 */
	boolean Update(User user) throws SQLException;
}
