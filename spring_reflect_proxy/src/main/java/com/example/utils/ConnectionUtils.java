package com.example.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private  DataSource dataSource;
    ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){

        Connection conn = t1.get();
        if (conn==null){
            try {
                conn = dataSource.getConnection();
                t1.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void removeConnection() {
        t1.remove();
    }
}
