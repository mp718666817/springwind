package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class LoadFileUtils {
	public static void getPath(ServletContext sc) throws IOException {
		InputStream in = LoadFileUtils.class.getClassLoader().getResourceAsStream("db.ini");
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro.getProperty("driver"));
	}
}
