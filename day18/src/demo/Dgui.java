package demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dgui {
	public static void main(String[] args) {
		File file1 = new File("D:\\BaiduNetdiskDownload\\敬哥\\javaSE");
		List<File> list = new ArrayList<>();
		list = getPath(file1,list);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	private static List getPath(File file1,List<File> list) {
		File[] file2 = file1.listFiles();  
		for(File file:file2) {
			if (file.isFile()) {
				list.add(file);
			}
			else {
				return getPath(new File(file.getAbsolutePath()),list);
			}
		}
		return list;
	}

}
