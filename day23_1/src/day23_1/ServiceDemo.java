package day23_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServiceDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 *     ����������
		 * 
		 */
		DatagramSocket ds = new  DatagramSocket(8889);
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys,500);
		// ��������
		ds.receive(dp);
		
		ds.close();//�ر�
		System.out.println("���Կͻ��˵���Ϣ��"+new String(bys,0,100));
		
	}
}
