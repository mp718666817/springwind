package web_login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Goods;
import service.GoodsService;

public class GoodsServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Goods> list = new ArrayList<Goods>();
		list = new GoodsService().getGoods();
		req.setAttribute("list", list);
		req.getRequestDispatcher("goods.jsp").forward(req, resp);
	}
	
}
