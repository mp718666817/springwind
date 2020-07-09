package web_login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsDao;
import dao.GoodsDaoImp;
import domain.Cart;
import service.UserService;

public class BuyGoodsServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodsId = req.getParameter("goodsId");
		HttpSession session = req.getSession();
		UserService userService = new UserService();
		userService.buyGoods(session, goodsId);
		resp.setContentType("text/html;charset=utf-8");
		ServletOutputStream out = resp.getOutputStream();
		out.write(("购物成功是否继续<a href='"+req.getContextPath()+ "/GoodsServlet'>购物</a>查看<a href='"+req.getContextPath()+"/cart.jsp'>购物车</a>").getBytes());
	} 
}
