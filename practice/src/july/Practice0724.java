package july;

public class Practice0724 {

	public static void main(String[] args) {
		//HelloWorld 7번출력
		int i = 0;
		while(i<7) {
			System.out.println("HelloWorld");
			i=i+1;
		}
		
		
		//1-10까지의 합계
		i=1;
		int sum=0;
		while(i<11) {
			sum=sum+i;
			i=i+1;
		}
		System.out.println("");
		System.out.println(sum);
		
		
		//1-10 중에서 홀수들의 합계
		int hap=0;
		i=1;
		while(i<6) {
			hap = hap+((i*2)-1);
			i=i+1;
		}
		System.out.println("");
		System.out.println(hap);
		
		
		//1-6까지 평균 - 소수가 나오도록	
		i=1;
		sum=0;
		while(i<7) {
			sum=sum+i;
			i=i+1;
		}
		System.out.println("");
		System.out.println(sum/(double)6);				
	}
}
