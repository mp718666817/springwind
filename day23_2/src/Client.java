import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	
	/*
	 * �����ͻ���
	 */
	
	public static void main(String[] args) {
		/*
		 * Socket(InetAddress address, int port) 
        *  ����һ�����׽��ֲ��������ӵ�ָ�� IP ��ַ��ָ���˿ںš�
		 * 
		 */
		InetAddress address;
		try {
			System.out.println("�ͻ�������");
			address = InetAddress.getLocalHost();
			//�����ͻ���
			Socket client = new Socket(address, 8889);
			
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			
			//��ȡ������������
			new ReadServer(in).start();
			
			//����������д����
			new WriteServer(out).start();
			
			
			
			
		
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

class  ReadServer extends Thread{
	InputStream in;

	public ReadServer(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));		
		String str = null;

		try {
			while((str=br.readLine())!=null) {
				System.out.println("���Է����������ݣ�"+str);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}


class WriteServer extends Thread{
	OutputStream out;

	public WriteServer(OutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		
		
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		//���� Scanner ��ȡ����̨����Ϣ
		Scanner scan = new  Scanner(System.in);
		while(true) {
				System.out.println("��д��Ҫ���͵������������ݣ�");
				String nextLine = scan.nextLine();
				try {
					bw.write(nextLine);
					bw.newLine();
					bw.flush();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}