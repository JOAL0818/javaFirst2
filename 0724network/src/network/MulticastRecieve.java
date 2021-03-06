package network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastRecieve {

	public static void main(String[] args) {
		try {
			//멀티캐스트 소켓만들기 
			MulticastSocket ms = new MulticastSocket(9999);
			//그룹에참여 - 224.0.0.0부터 239.255.255.255 사이의 주소
			ms.joinGroup(InetAddress.getByName("230.100.50.5"));
			//무한반복해서 메시지 받기
			while(true) {
				//바이트배열생성
				byte [] b = new byte[512];
				//데이터를 전송받을 패킷만들기
				DatagramPacket dp = new DatagramPacket(b,512);
				//데이터받기 : 데이터가 올때까지 대기
				ms.receive(dp);
				//바이트 배열을 문자열로 변환하기
				String msg = new String(b);
				//화면에 공백을 제거하고 출력
				System.out.println(msg.trim());
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
