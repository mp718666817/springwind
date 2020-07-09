package utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	private static ComboPooledDataSource csp = new ComboPooledDataSource();
	public static Connection getConn() {
		try {
			return csp.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
