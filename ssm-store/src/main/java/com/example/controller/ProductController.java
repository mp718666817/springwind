package com.example.controller;

import com.example.entity.Page;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/product_info")
    public ModelAndView product_info(HttpServletRequest request){
        String pid = request.getParameter("pid");
        try {
            Product product = productService.findById(pid);
            System.out.println("跳转页面成功");
            ModelAndView mv = new ModelAndView();
            mv.setViewName("product_info");
            mv.addObject("product",product);
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/product_list")
    @ResponseBody
    public List<Product> product_list(HttpServletResponse response){
        try {
            List<Product> hotProductList = productService.findHotProductList();
            return hotProductList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/findPageByCid")
    public ModelAndView findByPage(@RequestParam String cid,String currPage){
        try {
            System.out.println(cid+currPage);
            Page page = productService.findListByCid(cid, currPage);
            ModelAndView mv = new ModelAndView();
            mv.addObject("page",page);
            mv.setViewName("product_list");
            return  mv;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam String pid){
        Product product = productService.findById(pid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product);
        mv.setViewName("product_info");
        return mv;

    }
}
