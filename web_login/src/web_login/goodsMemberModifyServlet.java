package web_login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;

/**
 * Servlet implementation class goodsMemberModifyServlet
 */
@WebServlet("/goodsMemberModifyServlet")
public class goodsMemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsMemberModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodsId = req.getParameter("goodsId");
		UserService userService = new UserService();
		HttpSession session = req.getSession();
		boolean msg = userService.buyGoods(session, goodsId);
		ServletOutputStream out = resp.getOutputStream();
		if (msg) {
			out.write("true".getBytes());
		}
		else {
			out.write("false".getBytes());
		}
	}
    

}
