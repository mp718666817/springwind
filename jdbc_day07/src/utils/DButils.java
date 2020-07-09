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

import ds.MyConnection;
import ds.MyDataSource;

public class DButils {
	private static String driverClass=null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	public static Connection conn = null;
	private static ResultSet rs = null;
	public static Statement statement = null;
	static MyDataSource myDataSource = new MyDataSource();
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
	public static List<Map<String,Object>> query(String sqlString,Object[] datas) throws SQLException {
		conn=getConn();
		preparedStatement=conn.prepareStatement(sqlString);
		if (datas!=null) {
			for (int i = 0; i < datas.length; i++) {
				preparedStatement.setObject((i+1), datas[i]);
			}
		}
		rs=preparedStatement.executeQuery();
		ResultSetMetaData rm = rs.getMetaData();
		int count = rm.getColumnCount();
		while(rs.next()) {
			int index=1;
			map = new HashMap<String, Object>();
			while(index<=count) {
				String columnName = rm.getColumnName(index);
				Object object = rs.getObject(columnName);
				map.put(columnName, object);
				index++;
			}
			list.add(map);
		}
		return list;
	}
	public static <T>List<T> executeBean(String sql,Object[]datas,Class<T> clazz) {
		try {
			conn = getConn();
			conn = new MyConnection(conn, myDataSource);
			preparedStatement = conn.prepareStatement(sql);
			if (datas!=null) {
				for (int i = 0; i < datas.length; i++) {
					preparedStatement.setObject((i+1), datas[i]);
				}
			}
			List<T> list = new ArrayList<T>();
			rs=preparedStatement.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			while(rs.next()) {
				int index=1;
				T newInstance = clazz.newInstance();
				while(index<=count) {
					String columnName = rm.getColumnName(index);
					Object object = rs.getObject(columnName);
					Field cField = clazz.getDeclaredField(columnName);
					cField.setAccessible(true);
					cField.set(newInstance,object);
					index++;
				}
				list.add(newInstance);
			}
			return list;
			
			
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeAll();
		}
		return null;
	}
	public static boolean executeUpdate(String sql,Object[] datas) throws SQLException {
		conn=myDataSource.getConnection();
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
			myDataSource.back(conn);
		}
		if (conn!=null) {
			conn=null;
		}
		if (preparedStatement!=null) {
			preparedStatement=null;
		}
	}
}
 