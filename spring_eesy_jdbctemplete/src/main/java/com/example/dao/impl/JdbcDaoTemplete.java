package com.example.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcDaoTemplete {
    //jdbc的templete可以执行crud语句
    JdbcTemplate template;

    DriverManagerDataSource ds;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void setDs(DriverManagerDataSource ds) {
        if (template==null){
            template = createTemplate(ds);
        }
    }

    private JdbcTemplate createTemplate(DriverManagerDataSource ds) {
        return new JdbcTemplate(ds);
    }
}
