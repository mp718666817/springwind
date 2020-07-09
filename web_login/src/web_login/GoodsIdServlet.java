package web_login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Goods;
import service.GoodsService;

public class GoodsIdServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		String goodsId = req.getParameter("goodsId");
		Goods goods = goodsService.getGoodsId(goodsId);
		req.setAttribute("good", goods);
		req.getRequestDispatcher("good.jsp").forward(req, resp);
	}
	
}
