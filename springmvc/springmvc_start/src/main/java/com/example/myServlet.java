package com.example;

import com.example.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myServlet {
    @RequestMapping(path="/hello")
    public String goSuccessPage(String name){
        System.out.println("HELLO WORLD"+name);
        return "success";
    }
    @RequestMapping(path="/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        System.out.println(account.getUser());
        return "success";
    }
}
