package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) {
		try {
			//서버소켓생성
			ServerSocket ss = new ServerSocket(9999);
			while(true) {
				System.out.println("서버대기중...");
				//Client의 접속대기 - Client가 접속하면, 통신을 위해 Socket을 리턴하고 다음줄 코드실행
				Socket socket = ss.accept();  
				//한줄의 데이터를 읽어서 출력
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println("메시지:"+msg);
				System.out.println("접속자:"+socket.getInetAddress());
				br.close();
				socket.close();		
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
