package network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {
	public static void main(String[] args) {
		try {
			//������ ��Ƽĳ��Ʈ ������ ����
			MulticastSocket ms = new MulticastSocket();
			//���ڿ��� �Է¹ޱ����� ��ĳ�ʸ����
			Scanner sc = new Scanner(System.in);
			System.out.println("�г��� �Է� :");
			String nick = sc.nextLine();
			while(true) {
				System.out.print("�޽���(�����end):");
				String msg = sc.nextLine();
				if(msg.equals("end")) {
					msg=nick+"���� �����ϼ̽��ϴ�.";
					//��������Ŷ����� - ����,����,�������� �ּ�, ��Ʈ��ȣ
					DatagramPacket dp = new DatagramPacket(msg.getBytes(),
							msg.getBytes().length,InetAddress.getByName("230.100.50.5"),9999);
									
				//����������
				ms.send(dp);
				//���ϰ� ��ĳ�ʴݱ�
				ms.close();
				sc.close();
				break; //return�̳� break���� else�� �Ƚᵵ �ȴ�. 
				
				}else {		
					//�޽��������
					msg=nick+":"+msg;
					//������ ��Ŷ�����
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
