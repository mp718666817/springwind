package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class copyFile_1 {
	public static void main(String[] args) throws IOException {
		File file = new File("aa.txt");
		InputStream in = new FileInputStream(file); 
		OutputStream out = new FileOutputStream(new File(Math.random()+file.getName().substring(file.getName().indexOf('.'))));
		/*
		 * int len = 0; while ((len=in.read())!=-1) { out.write(len); }
		 */
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len=in.read(bys))!=-1) {
			out.write(bys, 0, len);
		}
		in.close();
		out.close();
	}
	@Test
	public void a1() throws Throwable {
		File file = new File("aa.txt");
		FileReader in = new FileReader(file);
		FileWriter out = new FileWriter(new File(Math.random()+file.getName().substring(file.getName().indexOf('.'))));
		char[] c = new char[100];
		int len = 0;
		while ((len= in.read(c))!=-1) {
			out.write(c, 0, len);
		}
		in.close();
		out.close();
	}
}