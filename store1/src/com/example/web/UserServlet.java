package com.example.web;

import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("userServlet")
public class UserServlet extends BaseServlet {
    private UserService uservice = new UserServiceImpl();
    public void regiter(HttpServletRequest req, HttpServletResponse resp)
    {

    }
}
