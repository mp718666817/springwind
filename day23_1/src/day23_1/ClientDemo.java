package day23_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 客户端
		 */
		
		DatagramSocket ds = new DatagramSocket();
		
		String str = "今天晚上去，看电视...";
		byte[] bys = str.getBytes();
		
		InetAddress localHost = InetAddress.getLocalHost();
		
		//构建数据报包
		DatagramPacket dp = new  DatagramPacket(bys, bys.length, localHost, 8889);
		
		ds.send(dp);
		
		ds.close();
		
	}
}
