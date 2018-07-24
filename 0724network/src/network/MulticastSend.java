package network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {
	public static void main(String[] args) {
		try {
			//보내는 멀티캐스트 소켓을 생성
			MulticastSocket ms = new MulticastSocket();
			//문자열을 입력받기위한 스캐너만들기
			Scanner sc = new Scanner(System.in);
			System.out.println("닉네임 입력 :");
			String nick = sc.nextLine();
			while(true) {
				System.out.print("메시지(종료는end):");
				String msg = sc.nextLine();
				if(msg.equals("end")) {
					msg=nick+"님이 퇴장하셨습니다.";
					//보내는패킷만들기 - 내용,길이,받을곳의 주소, 포트번호
					DatagramPacket dp = new DatagramPacket(msg.getBytes(),
							msg.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
									
				//데이터전송
				ms.send(dp);
				//소켓과 스캐너닫기
				ms.close();
				sc.close();
				break; //return이나 break쓰면 else를 안써도 된다. 
				
				}else {		
					//메시지만들기
					msg=nick+":"+msg;
					//전송할 패킷만들기
					DatagramPacket dp = new DatagramPacket(msg.getBytes(),
							msg.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
					ms.send(dp);
				}									
			}			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
