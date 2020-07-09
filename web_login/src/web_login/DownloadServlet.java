package web_login;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("fileName");
		ServletOutputStream out = resp.getOutputStream();
		if (filename==null||"".equals(filename)) {
			return;
		}
		ServletContext sc = req.getServletContext();
		InputStream in = sc.getResourceAsStream("/images/"+filename);
		/*设置头部信息*/
		String mimeType = sc.getMimeType(filename);
		resp.setHeader("Content-Type", mimeType);
		resp.setHeader("Content-Disposition","attachment;filename="+filename);
		int len=0;
		byte[] bys = new byte[1024];
		while((len=in.read(bys))!=-1) {
			out.write(bys, 0, len);
		}
	}

}
