package bytestream;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		//키보드로부터 입력받는 Scanner 인스턴스 만들기
		//정수입력받고 문자열 입력받는건 안되지만, 문자열입력받고 정수입력받는 건 가능 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름");
		String y = sc.nextLine();
		System.out.println(y);
		
		
		System.out.print("정수");
		int x = sc.nextInt();
		System.out.println(x);
		
		
		
		sc.close();

	}

}
