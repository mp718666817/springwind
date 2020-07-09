package web_login;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import utils.CountUtil;
import utils.DateUtil;
import utils.HistoryTimeUtil;

public class ServletDemo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("pwd");
		User user = new User(name, password);
		/* 判断是否能够传入成功 */
		UserService userService = new UserService();
		resp.setContentType("text/html;charset=utf-8");
		ServletOutputStream out = resp.getOutputStream();
		ServletContext sc = req.getServletContext();
		boolean login = true;
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		try {
			// login = userService.login(user);
			/* 响应浏览器 */
			if (login) {
				// out.write("登录成功".getBytes());
//					resp.setStatus(302);
//					resp.addHeader("Refresh","0;url=/web_login/time.html");
				cookie = HistoryTimeUtil.getTime(cookies, "historyTime");
				sc = CountUtil.getCount(sc);
				Object count = sc.getAttribute("count");
				if (cookie == null) {
					cookie = new Cookie("historyTime", System.currentTimeMillis()+"");
					out.write(("登录成功,你是第" + count + "位登陆")
							.getBytes());
				} else {
					System.out.println(Long.parseLong(cookie.getValue()));
					out.write(("登录成功,你是第" + count + "位登陆成功，上次登录的时间" + DateUtil.getTime(cookie.getValue(), "yyyy-MM-dd hh:mm:ss"))
							.getBytes());
					cookie.setValue(System.currentTimeMillis()+"");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.write(e.getMessage().getBytes());
		}
		out.write(("商品列表请点击<a href='"+req.getContextPath()+"/GoodsServlet'>商品列表</a>").getBytes());
		cookie.setMaxAge(60*60);
		cookie.setPath("/web_login");
		resp.addCookie(cookie);
	}
}
