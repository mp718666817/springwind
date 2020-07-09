package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DButils {
	private static String driverClass=null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	public static Connection conn = null;
	private static ResultSet rs = null;
	public static Statement statement = null;
	public static List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	public static Map<String, Object> map;
	public static PreparedStatement preparedStatement= null;
	static {
		/*初始化类中成员变量*/
		Properties pro = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream("src/db.ini");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverClass = pro.getProperty("driverClass");
		url = pro.getProperty("url");
		password = pro.getProperty("password");
		user = pro.getProperty("user");
	}
	public static Connection getConn() throws SQLException {
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url,user,password);
	}
	/*
	 * 
	 */
	public static boolean executeUpdate(String sql,Object[] datas) throws SQLException {
		conn=DataSourceUtils.getConn();
		try {
			preparedStatement=conn.prepareStatement(sql);
			if (datas!=null) {
				for (int i = 0; i < datas.length; i++) {
					preparedStatement.setObject((i+1), datas[i]);
				}
			}
			return preparedStatement.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public static boolean executeUpdate_transaction(String sql,Object[] datas,Connection conn) throws SQLException {
		try {
			preparedStatement=conn.prepareStatement(sql);
			if (datas!=null) {
				for (int i = 0; i < datas.length; i++) {
					preparedStatement.setObject((i+1), datas[i]);
				}
			}
			return preparedStatement.executeUpdate()>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return false;
	}
	public static void closeAll() {
		if (rs!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			conn=null;
		}
		if (preparedStatement!=null) {
			preparedStatement=null;
		}
	}
}
 