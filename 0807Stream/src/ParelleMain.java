import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ParelleMain {
	
	//1초대기하는 메소드
	public static void work(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int [] ar = {20,30,20,30,20,20,20,20,10,20};
		
		//일반스트림으로 work작업을 수행
		IntStream stream = Arrays.stream(ar); 
		long start = System.currentTimeMillis();
		stream.forEach(su -> work(su));
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		//병렬스트림으로 work작업을 수행
		stream = Arrays.stream(ar); 
		start = System.currentTimeMillis();
		stream.parallel().forEach(su -> work(su));
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		
	}

}
