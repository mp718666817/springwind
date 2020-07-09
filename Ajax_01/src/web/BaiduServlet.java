package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.handlers.ArrayListHandler;

import utils.DButils;

/**
 * Servlet implementation class BaiduServlet
 */
@WebServlet("/BaiduServlet")
public class BaiduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaiduServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titleValue = req.getParameter("TiltleValue");
		String val = "%"+titleValue+"%";
		try {
			List<Object[]> query = DButils.getQueryRunner().query("select string from title where string like ?",val, new ArrayListHandler());
			ServletOutputStream out = resp.getOutputStream();
			StringBuffer sb = new StringBuffer();
			for (Object[] objects : query) {
				sb.append("<p>"+objects[0]+"</p>");
			}
			out.write(sb.toString().getBytes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    

}
