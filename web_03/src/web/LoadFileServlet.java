package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.LoadFileUtils;

public class LoadFileServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		/*
		 * InputStream in = sc.getResourceAsStream("/WEB-INF/classes/db.ini");
		 * Properties pro = new Properties(); pro.load(in); String driver =
		 * pro.getProperty("driver");
		 * System.out.println("----------------------------");
		 * System.out.println(driver);
		 */
		LoadFileUtils.getPath(sc);
	}

}
