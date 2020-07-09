package demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientDemo {
	public static void main(String[] args) throws IOException {
		DatagramSocket client = new DatagramSocket();
		byte[] bys = "Hello BS".getBytes(); 
		
		/*获取主机的inetAddress对象*/
		InetAddress byName = InetAddress.getByName("DESKTOP-THTH4QA");
		DatagramPacket dp = new DatagramPacket(bys,bys.length,byName,61555);
		/*发送数据*/
		client.send(dp);
		client.close();
	}
}
   