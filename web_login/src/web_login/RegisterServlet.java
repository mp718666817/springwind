package web_login;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import exception.UserServiceException;
import service.UserService;
import utils.DateUtil;

public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*获取表单参数*/
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String passwrod = req.getParameter("pwd");
		String email = req.getParameter("email");
		String birthday = req.getParameter("brithday");
		/*转换为时间对象*/
		Date date = DateUtil.getDate(birthday, "yyyy-MM-dd");
		/*获取user对象*/
		User u = new User(name, passwrod, email, date);
		/*是否在数据库中查询到数据*/
		UserService userService = new UserService();
		boolean flag=false;
		try {
			flag = userService.insert(u);
		} catch (UserServiceException e) {
			e.printStackTrace();
		}
		if (flag) {
			resp.sendRedirect("/web_login/registersuccess.html");
		}
		else {
			ServletOutputStream out = resp.getOutputStream();
			out.write("注册失败".getBytes());
		}
		
	}
	
}
