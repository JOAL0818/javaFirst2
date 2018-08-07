package august;

import java.util.Scanner;

public class practice0731 {

	public static void main(String[] args) {
	 int[][] calendar = new int[6][7];
	 int i=0;
	 while(i<6) {
		 int j=0;
		 while(j<7) {
			 System.out.printf("%3d",calendar[i][j]);
			 j=j+1;
		 }
		 System.out.println("");
		 i=i+1;
	 }
	 
	 for(int [] ar:calendar) {
		 for(int value:ar) {
			 System.out.printf("%3d", value);
		 }
		 System.out.println("");
	 }
	 
	Scanner sc = new Scanner(System.in);
	System.out.print("년도");
	int year= sc.nextInt();
	System.out.print("월");
	int month = sc.nextInt();
	
	int cnt=0;
	int a=1;
	while(a<year) {
		if(a%4==0&&a%100!=0||a%400==0) {
			cnt=cnt+366;			
		}
		else {
			cnt=cnt+365;
		}
		a=a+1;
	}
	System.out.println(cnt%7); 
	 
	}
}
