package com.example.ui;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class beanFactory {
/*    private static  Map<String,Object> beans;
    //UserService userService = new UserServiceImpl();
    public static Map<String, Object> show() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        InputStream in = beanFactory.class.getClassLoader().getResourceAsStream("pb.properties");
        Properties pro = new Properties();
        pro.load(in);
        Enumeration<Object> keys = pro.keys();
        while (keys.hasMoreElements()){
            String o = (String)keys.nextElement();
            String beanPath = pro.getProperty(o);
            Object obj = Class.forName(beanPath).newInstance();
            beans =new HashMap<String, Object>();
            beans.put(o,obj);
        }
        return beans;
    }*/
    public  UserService getUserService(){
        return new UserServiceImpl();
    }


}
