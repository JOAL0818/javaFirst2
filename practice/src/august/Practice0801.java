package august;

import java.util.Scanner;

public class Practice0801 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도");
		int year= sc.nextInt();
		System.out.print("월");
		int month = sc.nextInt();
		sc.close();
		
		
		int nalsu =0;
		int idx=1;
		while(idx<year) {
			if(idx%4==0&&idx%100!=0||idx%400==0) {
				nalsu=nalsu+366;
				
			}else {
				nalsu=nalsu+365;
			}
			idx=idx+1;
		}
		
		
		int [] monthdays= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(idx%4==0&&idx%100!=0||idx%400==0) {
			monthdays[2]=29;
		}
			idx=1;
			while(idx<month) {
				nalsu=nalsu+monthdays[idx];
				idx=idx+1;
			}					
		//System.out.println(nalsu%7);	
		
		
		int [][] calendar = new int [6][7];
		int su=1;
		int week=nalsu%7;
		while(su<=monthdays[month]) {
			int x=week+su;
			calendar[x/7][x%7]=su;
			su=su+1;
		}
		
		
		for(int[] ar:calendar) {
			for(int temp:ar) {
				if(temp==0) {
					System.out.print("    ");
				}else {
					System.out.printf("%4d", temp);
				}
				
			}System.out.println();	
		}
				
	}
}
