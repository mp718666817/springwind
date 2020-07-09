package com.example.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        Class<? extends BaseServlet> aClass = this.getClass();

        try {
            Method method1 = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            String view = (String)method1.invoke(this, req, resp);
            if (view!=null){
                if (view.contains("redirect:"));
                resp.sendRedirect(view.replaceAll("redirect",""));
            }
            else
            {
                req.setAttribute("method",method);
                req.getRequestDispatcher("/"+view+".jsp").forward(req,resp);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
