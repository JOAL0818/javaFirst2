
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		//1초마다 쉬면서 1부터 10까지 출력
		int i=1;
		while(i<11) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			i=i+1;
		}
	}
}
