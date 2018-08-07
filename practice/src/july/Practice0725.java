package july;

public class Practice0725 {

	public static void main(String[] args) {
		//2단 만들기 = for문 이용
		for(int i=1;i<10;i=i+1) {
			System.out.println("2*"+i+"="+2*i);
		}
	
		
		System.out.println("");
		//2단 만들기 - while문 이용
		int i=1;
		while(i<10) {
			System.out.println("2*"+i+"="+2*i);
			i=i+1;
		}
		
				
		System.out.println("");
		//구구단 만들기 - for문 이용
		for(int j=2;j<10;j=j+1) {
			for(i=1;i<10;i=i+1) {
				System.out.print(j+"*"+i+"="+j*i+" ");
			}
			System.out.println("");
		}
	
					
		System.out.println("=============================");
		//구구단 만들기 - while문 이용
		i=1;
		
		while(i<10) {
			int j=2;
			while(j<10) {
				System.out.printf("%2d * %2d = %2d",j,i,j*i);
				j++;				
			}
			System.out.println("");
			i++;
		}
		
		
		//별찍기 ***** 세줄 - for문 이용
		for(int j=0;j<3;j++) {
			for(i=0;i<5;i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
		System.out.println("");
		//별찍기 ***** 세줄 - while문 이용
		int j=0;
		while(j<3) {
			i=0;
			while(i<5) {
				System.out.print("*");
				i++;
			}
			System.out.println("");
			j++;
		}
		
		System.out.println("----------");
		
	}
}