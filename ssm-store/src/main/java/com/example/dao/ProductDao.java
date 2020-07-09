package com.example.dao;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    /**
     * 根据pid查询商品
     * @param pid
     * @return
     */
    @Select("select * from product where pid=#{pid}")
    Product findById(String pid);

    /**
     *  按生产日期降序查询"热门商品"前N条
     * @return
     */
    @Select("select * from product where is_hot=1 ORDER BY pdate desc LIMIT 0,10")
    List<Product> findHotProductList() throws Exception;

    /**
     * 查询总的页数
     * @param cid
     * @param pflag
     * @return
     */
    @Select("select count(pid) from product where cid=#{cid} and pflag=#{pflag} ")
    int getTotalCount(@Param("cid") String cid, @Param("pflag") int pflag);

    /**
     * 查询某类别，根据分页查询
     * @param cid
     * @param beginRows
     * @param pageSize
     * @return
     */
    @Select("select * from product where cid=#{cid} ORDER BY pdate desc limit #{beginRows},#{pageSize}")
    List<Product> findPageByCid(@Param("cid") String cid, @Param("beginRows") Integer beginRows, @Param("pageSize") Integer pageSize);
}
