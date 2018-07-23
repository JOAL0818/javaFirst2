package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		try {
			//주소정보 1개 가져오기 - IP주소가 출력된다.
			InetAddress addr = InetAddress.getByName("www.choongang.co.kr");
			System.out.println(addr);
			
			//주소정보 여러개 가져오기 
			InetAddress [] ar = InetAddress.getAllByName("www.naver.com");
			//배열은 사용할때 항상  for(임시변수 : 배열이름) 이렇게 사용한다.
			for(InetAddress imsi:ar) {
				System.out.println(imsi);
			}
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}

	}

}
