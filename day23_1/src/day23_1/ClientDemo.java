package day23_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * �ͻ���
		 */
		
		DatagramSocket ds = new DatagramSocket();
		
		String str = "��������ȥ��������...";
		byte[] bys = str.getBytes();
		
		InetAddress localHost = InetAddress.getLocalHost();
		
		//�������ݱ���
		DatagramPacket dp = new  DatagramPacket(bys, bys.length, localHost, 8889);
		
		ds.send(dp);
		
		ds.close();
		
	}
}
