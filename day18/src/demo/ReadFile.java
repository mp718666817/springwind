package demo;
import java.io.File; 
import java.util.ArrayList; 
import java.util.List;

public class ReadFile { 
	public static void getFiles(String path,ArrayList<File> list) throws Exception {
        //目标集合fileList
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileIndex : files) {
                //如果这个文件是目录，则进行递归搜索
                if (fileIndex.isDirectory()) {
                    getFiles(fileIndex.getPath(),list);
                } else {
                    //如果文件是普通文件，则将文件句柄放入集合中
                    list.add(fileIndex);
                }
            }
        }
    }
	public static void main(String[] args) throws Exception {

        ArrayList<File> fileList = new ArrayList<File>();
        ReadFile.getFiles("D:\\BaiduNetdiskDownload\\敬哥\\javaSE",fileList);
        for (File file : fileList) {
        	if (file.toString().contains(".java")) {
        		System.out.println(file);
			}
		}
        
    }
}
