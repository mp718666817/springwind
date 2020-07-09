package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器参数
        String msg = null;
        String code = req.getParameter("code");
        UserService userService = new UserServiceImpl();
        boolean active = userService.active(code);
        System.out.println("hdhfhsfjodf");
        if(active)
        {
            msg="激活成功请<a href='http://localhost:8080/travel/login.html'>登录</a>";
        }
        else {
            msg="激活失败请联系管理员";
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(msg);
    }
}
