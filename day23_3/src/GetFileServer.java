import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 接收数据服务器
 */
public class GetFileServer {

	
	
	public static void main(String[] args) throws IOException {
		
		
		
		ServerSocket sc = new ServerSocket(8888);
		
		while(true) {
			Socket s = sc.accept();
		
			FileOutputStream out = new FileOutputStream("E:"+File.separator+Math.random()+".txt");
			InputStream in = s.getInputStream();
			byte[] bys = new byte[1024];
			int len =0;
			while((len=in.read(bys))!=-1) {
				out.write(bys,0,len);
				out.flush();
			}
			
			in.close();
			out.close();
			s.close();
		}
		
		
		
	}
	
	
}
