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
			//������������  ��ȡInetAddress
			InetAddress byName = InetAddress.getByName("tosit-PC");
			System.out.println(byName);
			//��ȡ ������Ip��ַ
			String hostAddress = byName.getHostAddress();
			System.out.println(hostAddress);
			//��ȡ��������
			String hostName = byName.getHostName();
			System.out.println(hostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
