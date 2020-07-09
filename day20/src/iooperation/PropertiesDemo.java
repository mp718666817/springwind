package iooperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		InputStream in = new FileInputStream("a.ini");
		pro.load(in);
		OutputStream outputStream =new FileOutputStream("c.ini");
		Enumeration elements = pro.elements();
		while (elements.hasMoreElements()) {
			String object = (String) elements.nextElement();
			System.out.println(object);
		}
		PrintStream out = new PrintStream(outputStream);
		pro.list(out);
	}

}
