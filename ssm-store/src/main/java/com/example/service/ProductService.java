package com.example.service;

import com.example.entity.Page;
import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * 根据pid查询商品
     * @param pid
     * @return
     */
    Product findById(String pid);
    /**
     *  按生产日期降序查询"热门商品"前N条
     * @return
     */
    List<Product> findHotProductList() throws Exception;

    /**
     * 根据编号查询页面
     * @param cid
     * @param currPage
     * @return
     */
    Page findListByCid(String cid,String currPage);
}
