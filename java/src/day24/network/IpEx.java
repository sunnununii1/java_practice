package day24.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpEx {

	public static void main(String[] args) {
		InetAddress inetAddress = null;
		
		//이름이 localhost인 곳의 IP 주소 정보를 가져옴(localhost는 모든 PC가 같음)
		try {
			inetAddress = InetAddress.getByName("localhost");
			System.out.println(inetAddress);
			//네이버 사이트의 아이피 주소 조회
			inetAddress = InetAddress.getByName("www.naver.com");
			System.out.println(inetAddress);
			//내 PC의 아이피 조회
			inetAddress = InetAddress.getLocalHost();
			System.out.println(inetAddress);
											
			
			InetAddress [] address = //getAllByName : 모든 아이피 주소 출력
					InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
