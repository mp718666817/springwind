package demo;

import java.sql.Connection;
import java.sql.SQLException;


import utils.DButils;
import utils.DataSourceUtils;

public class CardOperation {
	public static void main(String[] args) {
		Connection conn = DataSourceUtils.getConn();
		try {
			conn.setAutoCommit(false);
			String sql_1 = "update card set money=money-? where cardId=10001";
			String sql_2 = "update card set money=money+? where cardId=10002";
			int index=1;
			if (index==1) {
				throw new Exception("系统故障");
			}
			DButils.executeUpdate_transaction(sql_1, new Object[] {500},conn);
			DButils.executeUpdate_transaction(sql_2, new Object[] {500},conn);
			conn.commit();
		} catch (SQLException e2){
			e2.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
