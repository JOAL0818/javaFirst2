package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadCastReceive {

	public static void main(String[] args) {
		try {
			//UDP방식으로 데이터를 전송받을 수 있는 소켓만들기 - 포트번호 필요
			DatagramSocket ds = new DatagramSocket(7777);
			System.out.println("서버대기중...");
			while(true) {
				//메시지를 저장할 배열생성
				byte [] b = new byte[512];
				//메시지를 저장할 DatagramPacket생성
				DatagramPacket dp = new DatagramPacket(b,512);
				//데이터받기
				ds.receive(dp);
				//데이터 읽기
				String msg = new String(b);
				//512byte가 안될때 생기는 공백제거를 위해 trim호출
				System.out.println(msg.trim()); 
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
