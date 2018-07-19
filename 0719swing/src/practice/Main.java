package practice;

public class Main {

	public static void main(String[] args) {
		Object obj = new Object();
		//obj 인스턴스의 toString결과 출력
		//출력결과 java.lang.Object@7b1d7fff (뒤에 해시코드 - 주소)
		System.out.println(obj.toString()); 
		System.out.println(obj);

		Integer i = 100;
		//toString의 결과 -> 저장하고 있는 데이터 100
		System.out.println(i.toString());
		System.out.println(i);
		
		//상위클래스 타입의 참조형 변수에 하위클래스 타입의 인스턴스 참조를 대입할 수 있다.
		Object str ="Hello World";
		//출력할때는 형변환 하지 않아도 된다. -> toString()은 Object의 것이므로 호출이 가능
		System.out.println(str);
	
		//for(int i=0; i<str.length(); i=i+1) { //에러 : Object에는 length가 없어서
		//Object 타입의 변수는 출력할때를 제외하고는 원래의 자료형으로 강제형변환해서 사용
		String imsi = (String)str;
		for(int k=0;k<imsi.length();k=k+1){
		}
		
	}
}
