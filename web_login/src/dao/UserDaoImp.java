package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import domain.User;
import utils.DButils;

public class UserDaoImp implements UserDao{
	@Override
	public User FindByNameAndPwd(User user) throws SQLException {
		
		User u = DButils.getQueryRunner().query("select* from user where name=? and pwd=?",new Object[] {user.getName(),user.getPwd()}, new BeanHandler<>(user.getClass()));
		return u;
	}

	@Override
	public boolean Update(User user) throws SQLException {
		String sql = "insert into user value(null,?,?,?,?)";
		return DButils.getQueryRunner().update(sql, new Object[] {user.getName(),user.getPwd(),user.getEmail(),user.getBirthdayDate()})>0?true:false;

	}

}
