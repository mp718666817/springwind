package com.example.entity;

import java.io.Serializable;

/**
 *  商品种类 -- 由于ehcache要作该类对象的缓存, 所以该类要实现序列化
 * @author runmu
 * @version 1.0
 * @date 10:58 2019/5/18
 */
public class Category implements Serializable {
    private long serialVersionUID = 898095809685098650L;

    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
