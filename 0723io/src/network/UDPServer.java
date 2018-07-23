package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		//UDP ���۹޴� ��
		try {
			DatagramSocket ds = new DatagramSocket(5000);
			while(true) { //while���� ������ ���� �� �ִ�.
				//�����͸� ������ �迭 ����
				byte [] b = new byte[1024];
				//DatagramPacket ����
				DatagramPacket dp = new DatagramPacket(b,1024);
				//�����͹ޱ�
				ds.receive(dp);
				//�������а� ���
				String msg = new String(b,0, 1024);
				System.out.println("���� ��:"+dp.getAddress());
				System.out.println("�޽���:"+msg);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
