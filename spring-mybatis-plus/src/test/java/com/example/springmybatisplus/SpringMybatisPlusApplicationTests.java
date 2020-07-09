package com.example.springmybatisplus;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ResourceBundle;
import java.util.Scanner;

@SpringBootTest
class SpringMybatisPlusApplicationTests {
    public String scanner(String tip){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入" + tip + ":");
        System.out.println(stringBuilder.toString());
        if(scanner.hasNext()){
            String ipt = scanner.next();
            if(StringUtils.isNotEmpty(ipt)){
                //输入的不是空就返回
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip +"! ");
    }


    @Test
    void contextLoads() {

        ResourceBundle resource = ResourceBundle.getBundle("myBatisPlus");
        String outPutDir = resource.getString("outputDir");
        Boolean fileOverride = false;
        if ("true".equals(resource.getString("fileOverride"))) {
            fileOverride = true;
        }
        String url = resource.getString("url");
        String driverClass = resource.getString("driverClass");
        String userName = resource.getString("userName");
        String passWord = resource.getString("passWord");
        String setParent = resource.getString("setParent");

    }

}
