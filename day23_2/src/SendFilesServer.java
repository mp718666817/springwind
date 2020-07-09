import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �����ļ���������
 */
public class SendFilesServer {

	
	public static void main(String[] args) throws IOException {
	
			String path = "E:\\aa.txt";//�����ļ���ȫ·��
		
				
			InputStream in = new  FileInputStream(new File(path));
				
			byte[] bys = new byte[1024];
			int len = 0;
			Socket s = new Socket(InetAddress.getLocalHost(),8888);
			OutputStream out = s.getOutputStream();
			while((len=in.read(bys))!=-1) {
				out.write(bys, 0, len);
				out.write("\n".getBytes());
				out.flush();
			}
			
			in.close();
			out.close();
			s.close();	
	}
	
	
}
