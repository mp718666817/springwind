package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class BufferCopy {

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		date.getTime();
		long c1 = System.currentTimeMillis();
		readfile();
		long c2 = System.currentTimeMillis();
		System.out.println((c2-c1));
		c1 = System.currentTimeMillis();
		bufferfile();
		c2 = System.currentTimeMillis();
		System.out.println((c2-c1));
	}
	private static void bufferfile() throws IOException {
		String string = "aa.txt";
		File file = new File(string);
		if (!file.exists()) {
			return;
		}
		File file2 = new File(System.currentTimeMillis()+file.getName().substring(file.getName().indexOf(".")));
		if (!file2.exists()) {
			file2.createNewFile();
		}
		BufferedOutputStream ou = new BufferedOutputStream(new FileOutputStream(file2));
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		int len = 0;
		byte[] bys = new byte[1024];
		while ((len=in.read(bys))!=-1) {
			ou.write(bys, 0, len);
		};
	}
	private static void readfile() throws IOException {
		String string = "aa.txt";
		File file = new File(string);
		if (!file.exists()) {
			return;
		}
		File file2 = new File(System.currentTimeMillis()+file.getName().substring(file.getName().indexOf(".")));
		OutputStream out = new FileOutputStream(file2);
		if (!file2.exists()) {
			file2.createNewFile();
		}
		InputStream in = new FileInputStream(file);
		int len = 0;
		while ((len=in.read())!=-1) {
			out.write(len);
		}
		out.flush();
		in.close();
		out.close();
	}
}
