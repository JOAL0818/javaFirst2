package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		//UDP 전송받는 곳
		try {
			DatagramSocket ds = new DatagramSocket(5000);
			while(true) { //while쓰면 여러번 받을 수 있다.
				//데이터를 저장할 배열 생성
				byte [] b = new byte[1024];
				//DatagramPacket 생성
				DatagramPacket dp = new DatagramPacket(b,1024);
				//데이터받기
				ds.receive(dp);
				//데이터읽고 출력
				String msg = new String(b,0, 1024);
				System.out.println("보낸 곳:"+dp.getAddress());
				System.out.println("메시지:"+msg);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
