package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyImage {
	public static void main(String[] args) throws IOException  {
		String string = "cs20005.jpg";
		copyimage(string);
	}

	private static void copyimage(String string) throws IOException {
		File file = new File(string);
		if (!file.exists()) {
			return;
		}
		InputStream inputStream = new FileInputStream(string);
		File file2 = new File("aa.jpg");
		while (!file2.exists()) {
			file2.createNewFile();
		}
		OutputStream fileOutputStream = new FileOutputStream(file2);
		int len = 0;
		while((len=inputStream.read())!=-1) {
			fileOutputStream.write(len);
		}
		fileOutputStream.close();
		inputStream.close();
	}
}
