package com.example.dao;

import com.example.entity.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {
    /**
     * 查询所有种类
     * @return
     */
    @Select("select * from categroy")
    List<Category> findAll();
}
