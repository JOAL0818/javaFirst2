package bytestream;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		//Ű����κ��� �Է¹޴� Scanner �ν��Ͻ� �����
		//�����Է¹ް� ���ڿ� �Է¹޴°� �ȵ�����, ���ڿ��Է¹ް� �����Է¹޴� �� ���� 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸�");
		String y = sc.nextLine();
		System.out.println(y);
		
		
		System.out.print("����");
		int x = sc.nextInt();
		System.out.println(x);
		
		
		
		sc.close();

	}

}
