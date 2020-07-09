package cn.itcast.travel.dao.Impl;

import cn.itcast.travel.dao.CategroyDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.JDBCType;
import java.util.List;

public class CategroyDaoImpl implements CategroyDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        System.out.println("执行findALLdao");
        String sql = "select* from tab_category";
        return  template.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }

}
