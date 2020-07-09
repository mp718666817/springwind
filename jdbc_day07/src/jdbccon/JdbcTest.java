package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); Connection conn =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		 * System.out.println(conn); String sqlString = "select* from depts"; Statement
		 * statement = conn.createStatement(); ResultSet resultSet =
		 * statement.executeQuery(sqlString); while(resultSet.next()) { 数据行
		 * 
		 * int c_1=resultSet.getInt(1); String string = resultSet.getString(c_1);
		 * System.out.println(c_1+":"+string);
		 * 
		 * Object object1=resultSet.getObject("deptId"); Object
		 * object2=resultSet.getObject("name"); System.out.println(object1+":"+object2);
		 * }
		 */
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		query(conn);
		update(conn);
	}

	private static void update(Connection conn) throws SQLException {
		String sql = "delete from depts where deptId=5";
		Statement statement = conn.createStatement();
		int row = statement.executeUpdate(sql);
		if (row>0) {
			System.out.println("chenggong");
		}
		else {
			System.out.println("shibai");
		}
	}

	private static void query(Connection conn) throws SQLException {
		System.out.println(conn);
		String string = "select* from depts";
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(string);
		while(resultSet.next()) {
			Object object1 = resultSet.getObject("deptId");
			Object object2 = resultSet.getObject("name");
			System.out.println(object1+":"+object2);
		}
	}
}
