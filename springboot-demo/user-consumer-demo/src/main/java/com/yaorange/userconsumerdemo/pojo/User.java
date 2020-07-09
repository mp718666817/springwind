package com.yaorange.userconsumerdemo.pojo;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private Long id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 姓名
    private String phone;


    // 创建时间
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
