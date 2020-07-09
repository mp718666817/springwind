package com.example.service;

import com.example.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有种类
     * @return
     */
    List<Category> findAll();
}
