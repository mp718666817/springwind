package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Category;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/findAll")
    public void findAll(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Category> categoryList = categoryService.findAll();

            //将种类的集合--->json
            String json = JSON.toJSONString(categoryList);
            response.setContentType("text/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(json);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
