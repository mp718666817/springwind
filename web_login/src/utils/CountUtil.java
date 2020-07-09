package utils;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountUtil {
	static int indexcount = 0;
	public static ServletContext getCount(ServletContext sc) throws IOException {
		sc.setAttribute("count",indexcount+1);
		indexcount++;
		return sc;
	}
}
