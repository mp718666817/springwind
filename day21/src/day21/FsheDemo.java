package day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class FsheDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException {
		//method1();
		method2();
	}

	private static void method2() throws InstantiationException, IllegalAccessException {
		try {
			Class<Properties> class1 = Properties.class;
			try {
				Properties pro = class1.newInstance();
				Method m = class1.getDeclaredMethod("load",InputStream.class);
				
				try {
					Object inv = m.invoke(pro, new FileInputStream("src/db.ini"));
					Method u = class1.getDeclaredMethod("getProperty",String.class);
					Object object = null;
					System.out.println(u.invoke(pro,"driver")+":"+u.invoke(pro, "username"));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private static void method1() throws IOException, FileNotFoundException {
		Properties pro = new Properties();
		pro.load(new FileInputStream("src/db.ini"));
		String u1 = pro.getProperty("driver");
		String u2 = pro.getProperty("username");
		System.out.println(u1+"::::"+u2);
	}
}
