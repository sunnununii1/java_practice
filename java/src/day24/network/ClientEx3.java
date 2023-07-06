package day24.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClientEx3 {
	
	public static void main(String[] args) {
		int port = 5001; //1. 포트번호 설정
		String ip = "192.168.30.212"; //1-1. 서버 아이피 설정
		//ip = InetAddress.getLocalHost().getHostAddress(); //윗줄과의 차이 알기!
		Socket socket = new Socket(); //2. 소켓 생성
		try{
			//3. 서버(OP,posrt)에게 연결 요청
			socket.connect(new InetSocketAddress(ip,port));
			//연결 완료되면 읽기/쓰기 기능 실행하기 - 서킷이 연결 끊길 때까지
			Client client = new Client(socket);
			client.read();
			client.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}