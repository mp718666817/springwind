package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class copyFile {

	public static void main(String[] args) throws IOException {
		String string1 = "D:\\JAVA\\a";
		String string2 = "D:\\JAVA\\b";
		System.out.println(string1);
		File file1 = new File(string1);
		File file2 = new File(string2);
		List<String> list = new ArrayList();
		cofile(file1,file2);
		list = codirecotory(file1,list);
		createFile(file2,string1,list);
	}

	private static void createFile(File file2, String string1, List<String> list) {
		for (String string : list) {
			System.out.println(string.replaceAll(string1," "));
			File file = new File(file2.getAbsolutePath()+(string.replaceAll(string1, "")));
			file2.mkdir();
		}
	}

	private static List codirecotory(File file1, List<String> list) throws IOException {
		for(File file :file1.listFiles()) {
			if (file.isDirectory()) {
				list.add(file.getCanonicalPath());
				codirecotory(file,list);
			}
		}
		return list;
	}
	private static void cofile(File file1, File file2) {
		// TODO Auto-generated method stub
		
	}


}
