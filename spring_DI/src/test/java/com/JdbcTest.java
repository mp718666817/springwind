package com;

import com.mysql.cj.jdbc.Driver;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class JdbcTest {
    public static void main(String[] args) throws IOException, SQLException {
        InputStream in = ClassLoader.getSystemResourceAsStream("jdbcConfig.properties");
        Properties pro = new Properties();
        Driver driver = new Driver();
        pro.load(in);
        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(pro.getProperty("jdbc.url"), pro.getProperty("jdbc" +
                ".username"), pro.getProperty(
                "jdbc.password"));
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
        }
    }
}
