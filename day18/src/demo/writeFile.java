package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class writeFile {

	public static void main(String[] args) throws IOException {
		String string = "aa.txt";
		readfile(string);
	}

	private static void readfile(String string) throws IOException {
		File file = new File(string);
		if (!file.exists()) {
			return;
		}
		OutputStream out = new FileOutputStream(file);
		File file2 = new File((int)Math.random()*10+file.getName().substring(file.getName().indexOf(".")));
		if (!file2.exists()) {
			file2.createNewFile();
		}
		InputStream in = new FileInputStream(file2);
		int len = 0;
		byte[] bys = new byte[1024];
		while ((len=in.read(bys))!=-1) {
			out.write(bys, 0, len);
		}
		out.flush();
		in.close();
		out.close();
	}

}
