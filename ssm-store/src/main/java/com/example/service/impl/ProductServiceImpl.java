package com.example.service.impl;

import com.example.dao.ProductDao;
import com.example.entity.Page;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public Product findById(String pid) {
        System.out.println("ProductServiceImpl根据产品名查询");
        return productDao.findById(pid);
    }

    @Override
    public List<Product> findHotProductList() throws Exception {
        return productDao.findHotProductList();
    }

    @Override
    public Page findListByCid(String cid, String currPage) {

        if(currPage==null){
            currPage="1";
        }
        Page result = new Page();
        result.setCurrPage(Integer.parseInt(currPage));
        int totalCount = productDao.getTotalCount(cid, 0);//第2个参数为null证明不区分pflag的值(1和0都查询出来)
        result.setTotalCount(totalCount);

        List<Product> list = productDao.findPageByCid(cid, result.getBeginRows(), result.getPageSize());
        result.setList(list);

        return result;
    }
}
