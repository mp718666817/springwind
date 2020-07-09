package com.example.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class jdbcTemplete {
    //DriverManagerDataSource dataSource;
    JdbcTemplate template;

   /* public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void insert(){
        template.execute("intsert into account(name,money) value('ccc',1000)");
   }



}
