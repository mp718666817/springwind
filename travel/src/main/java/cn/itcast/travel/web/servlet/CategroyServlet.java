package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategroyService;
import cn.itcast.travel.service.impl.CategroyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/categroy/*")
public class CategroyServlet extends BaseServlet {
    CategroyService categroyService = new CategroyServiceImpl();
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行findAll");
        List<Category> list = categroyService.findCaAll();
        System.out.println(list.get(0).getCname());
        writeValue(list,resp);
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello world");
    }
}
