package day23_1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		
		/*
		 * public static InetAddress getByName(String host)
			public String getHostAddress()
			public String getHostName()
		 */
		
		try {
			//根据主机名称  获取InetAddress
			InetAddress byName = InetAddress.getByName("tosit-PC");
			System.out.println(byName);
			//获取 主机的Ip地址
			String hostAddress = byName.getHostAddress();
			System.out.println(hostAddress);
			//获取主机名称
			String hostName = byName.getHostName();
			System.out.println(hostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
