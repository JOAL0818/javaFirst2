package july;

import java.util.Scanner;

public class Practice0719 {

	public static void main(String[] args) {
		int a=10;
		boolean pan = a>5 && a++>3;
		System.out.println(pan);
		System.out.println(a);
		pan=a>100 && a++>50;
		System.out.println(pan);
		System.out.println(a); //12�� �ƴϰ� 11�̴�. 
		
		//1-100���� ������ 3�ǹ���̸� 4�� ����� ����ض�
		for(int i=1;i<=100;i++) {
			if(i%4==0&&i%3==0) {
			System.out.println(i);
			}	
		}
		
				
		//2018���� ¦������ Ȯ��(2�� ���� �������� 0)
		int year = 2018;
		System.out.println(year%2==0);
		
			
		//2018�� ¦���̰� 3�� ������� Ȯ��
		int pal = 2018;
		System.out.println(pal%3==0&&pal%2==0); 
		
						
		//2018�� ¦���̰ų� 3�� ������� Ȯ��
		int e = 2018;
		System.out.println(e%2==0||e%3==0);
			
				
		//x�� �������� Ȯ��(4�ǹ���̰� 100�� ����� �ƴϰų� 400�� ����̸� ����)/
		Scanner scn = new Scanner(System.in);
		System.out.println("�������� Ȯ���ϰ� ���� �⵵�� �Է����ּ���.");
		int x = scn.nextInt();		
		System.out.println((x%4==0)&&(x%100!=0)||(x%400==0)); 
				
	}
}
