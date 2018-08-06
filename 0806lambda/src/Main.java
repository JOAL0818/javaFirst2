
public class Main {

	public static void main(String[] args) {
		// 방1) 별도의 클래스를 만들어사용한다.
//		RunnableImpl r= new RunnableImpl();
//		Thread th = new Thread(r);
//		th.start();		
//		RunnableImpl r1= new RunnableImpl();
//		Thread th1 = new Thread(r1);
//		th1.start();

		// 익명클래스 이용하는 방법
		Runnable r = () -> {			
				// 1초마다 쉬면서 1부터 10까지 출력
				int i = 1;
				while (i <= 10) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i:"+i);
					i = i + 1;
				}			
		};
		Thread th = new Thread(r);
		th.start();
	}
}
