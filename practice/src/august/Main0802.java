package august;

public class Main0802 {

	public static void main(String[] args) {
		T0802 obj1 = new T0802();
		T0802 obj2 = new T0802();
		
		int a = 10;
		
		obj1.num=10;
		obj2.num=20;
		System.out.println(obj1.num);
		System.out.println(obj2.num);

		T0802.share="공유";
		System.out.println(obj1.share);
		
		obj1.share="수정";
		System.out.println(obj2.share);
		
		final int x =10;
		
		
	}

}
