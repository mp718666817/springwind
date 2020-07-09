package ds;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DPCPDemo {
	BasicDataSource ds = new BasicDataSource();
	BasicDataSourceFactory dsp=new BasicDataSourceFactory();
	@Test
	public void run()
	{
		
		try {
			/*
			 * ds.setDriverClassName("com.mysql.jdbc.Driver");
			 * ds.setUrl("jdbc:mysql://localhost:3306/test"); ds.setUsername("root");
			 * ds.setPassword("");
			 */
			Properties pro = new Properties();
			pro.load(new FileInputStream("src/db.ini"));
			DataSource createDataSource = dsp.createDataSource(pro);
			Connection conn = createDataSource.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
