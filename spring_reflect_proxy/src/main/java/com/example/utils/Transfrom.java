package com.example.utils;

import java.sql.SQLException;

public class Transfrom {
    ConnectionUtils conn;

    public void setConn(ConnectionUtils conn) {
        this.conn = conn;
    }

    public void beginTransaction(){
        try {
            conn.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void commit(){
        try {
            conn.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void rollback(){
        try {
            conn.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            conn.getThreadConnection().close();
            conn.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
