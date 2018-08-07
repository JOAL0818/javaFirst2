package july;

import java.util.Scanner;

public class array_0730 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("정수 5개를 입력하시오");
		int [] su = new int [5]; 
		int sum = 0;
		for(int imsi :su) {
			sum = sum+imsi;
		}
		System.out.println(sum);
		System.out.println(sum/(double)5);
		
		
		
	}

}
