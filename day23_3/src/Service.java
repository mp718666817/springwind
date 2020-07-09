import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {

	
	public static void main(String[] args) {
		
	
		
		// ����������
		try {
			System.out.println("����������");
			ServerSocket service = new ServerSocket(8889);
			// ���������ܵ����׽��ֵ����ӡ�
			while(true) {
					Socket sc = service.accept();
					//��ȡ�ͻ��˷�����������
					InputStream in = sc.getInputStream();
					//д���ݵ�������
					OutputStream out = sc.getOutputStream();
					//��ȡ�ͻ��˷��͵�����
					
			
					
					new ReadAndWriteClinet(in,out).start();
				
					
					
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}


class  ReadAndWriteClinet  extends  Thread{
	InputStream in ;
	OutputStream out ;

	
	
	

	public ReadAndWriteClinet(InputStream in, OutputStream out) {
		super();
		this.in = in;
		this.out = out;
	}





	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//д����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
	
		try {
			bw.write("��ӭ����!\n");
			bw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		String s = null;
			try {
				while((s=br.readLine())!=null) {
					System.out.println("���Կͻ��˵����ݣ�"+s);
					
					switch (s) {
						case "Hello":
							bw.write("���!");
							bw.newLine();
							bw.flush();
							break;
						case "����Ե�ɶ":
							bw.write("����!");
							bw.write("ϡ��!");
							bw.write("���!");
							bw.write("ţ��!");
							bw.newLine();
							bw.flush();
							break;
						case "����":
							bw.write("û�а���!");
							bw.newLine();
							bw.flush();
							break;
						case "���":
							bw.write("�������!");
							bw.newLine();
							bw.flush();
							break;
	
						default:
							bw.write("���ѡ������");
							bw.write("886");
							bw.newLine();
							bw.flush();
							break;
						}
					
					
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}


