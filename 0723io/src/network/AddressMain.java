package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		try {
			//�ּ����� 1�� �������� - IP�ּҰ� ��µȴ�.
			InetAddress addr = InetAddress.getByName("www.choongang.co.kr");
			System.out.println(addr);
			
			//�ּ����� ������ �������� 
			InetAddress [] ar = InetAddress.getAllByName("www.naver.com");
			//�迭�� ����Ҷ� �׻�  for(�ӽú��� : �迭�̸�) �̷��� ����Ѵ�.
			for(InetAddress imsi:ar) {
				System.out.println(imsi);
			}
			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}

	}

}
