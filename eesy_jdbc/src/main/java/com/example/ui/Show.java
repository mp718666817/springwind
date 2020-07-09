package com.example.ui;

import com.example.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Show {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //UserService userService = (UserService)ac.getBean("userService");
        //userService.saveService();
        beanFactory beanfactory = (beanFactory)ac.getBean("beanfactory");
        UserService userService = beanfactory.getUserService();
        userService.saveService();

        Resource resource = (Resource)new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        UserService userservice = (UserService) factory.getBean("userService");
        userService.saveService();
    }
}
