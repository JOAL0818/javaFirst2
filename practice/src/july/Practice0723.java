package july;

import java.util.Scanner;

public class Practice0723 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("�����ϳ��� �Է����ּ���");
		int su = scn.nextInt();
		if(su%2==0) {
			System.out.println("�Է��� ���� "+su+"��(��) ¦���Դϴ�.");
		}else {
			System.out.println("�Է��� ����"+su+"��(��) Ȧ���Դϴ�.");
		}
		
		System.out.println("");
		System.out.println("������ ������ �Է����ּ���");
		int score=scn.nextInt();
		if(score>=90) {
			System.out.println("�� �Դϴ�.");
		}else if(score>=80){
			System.out.println("�� �Դϴ�.");
		}else if(score>=70){
			System.out.println("�� �Դϴ�.");
		}else if(score>=60){
			System.out.println("�� �Դϴ�.");
		}else {
			System.out.println("�� �Դϴ�.");
		}
		
		System.out.println("");
		int gender =1;
		switch(gender) {
		case 1: 
			System.out.println("�����Դϴ�.");
			break;
		case 2: 
			System.out.println("�����Դϴ�.");
			break;
		default:
			System.out.println("�߼��Դϴ�.");
			}			
	}
}
