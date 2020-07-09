package com.example.service.impl;

import com.example.service.AccountServiece;
import com.example.service.AccountServiece;
import org.springframework.stereotype.Service;

@Service("accountservice")
public class AccountserviceImpl implements AccountServiece {

    @Override
    public void saveServie() {
        System.out.println("保存service运行");
    }

    @Override
    public int findAll() {
        System.out.println("执行findall方法");
        return 100;
    }
}
