package com.example.dao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@Configuration
@ComponentScan(value = "com.example")
public class SuperConfig {
    @Bean
    public ComboPooledDataSource getDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC");
            ds.setUser("root");
            ds.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }
    @Bean
    public QueryRunner getQueryRunner(ComboPooledDataSource ds){
        return new QueryRunner(ds);
    }

}
