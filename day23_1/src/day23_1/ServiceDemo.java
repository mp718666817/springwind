package day23_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServiceDemo {

	public static void main(String[] args) throws IOException {
		
		/*
		 *     建立服务器
		 * 
		 */
		DatagramSocket ds = new  DatagramSocket(8889);
		byte[] bys = new byte[1024];
		DatagramPacket dp = new DatagramPacket(bys,500);
		// 接收数据
		ds.receive(dp);
		
		ds.close();//关闭
		System.out.println("来自客户端的消息："+new String(bys,0,100));
		
	}
}
