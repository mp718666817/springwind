package demo;

import java.io.IOException;
import java.net.DatagramPacket; 
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("执行服务端");
		/*构建服务器*/
		try {
			DatagramSocket server = new DatagramSocket(61555);
			byte[] bys = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bys,1024);
			server.receive(dp);
			server.close(); 
			System.out.println(new String(bys));
		} catch (SocketException e) {
			e.printStackTrace();  
		}
	}
}
