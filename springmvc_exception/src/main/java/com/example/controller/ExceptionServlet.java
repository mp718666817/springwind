package com.example.controller;

import com.example.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ExceptionServlet {
    @RequestMapping("/exceptionServlet")
    public String ExceptionServlet1() throws SysException {
        try {
            int i = 10/0;
        }catch (Exception e){
            System.out.println("抛出异常，请处理！");
            e.printStackTrace();
            throw new SysException("发生异常请及时处理");
        }


        return "success";
    }
}
