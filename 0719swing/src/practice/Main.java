package practice;

public class Main {

	public static void main(String[] args) {
		Object obj = new Object();
		//obj �ν��Ͻ��� toString��� ���
		//��°�� java.lang.Object@7b1d7fff (�ڿ� �ؽ��ڵ� - �ּ�)
		System.out.println(obj.toString()); 
		System.out.println(obj);

		Integer i = 100;
		//toString�� ��� -> �����ϰ� �ִ� ������ 100
		System.out.println(i.toString());
		System.out.println(i);
		
		//����Ŭ���� Ÿ���� ������ ������ ����Ŭ���� Ÿ���� �ν��Ͻ� ������ ������ �� �ִ�.
		Object str ="Hello World";
		//����Ҷ��� ����ȯ ���� �ʾƵ� �ȴ�. -> toString()�� Object�� ���̹Ƿ� ȣ���� ����
		System.out.println(str);
	
		//for(int i=0; i<str.length(); i=i+1) { //���� : Object���� length�� ���
		//Object Ÿ���� ������ ����Ҷ��� �����ϰ�� ������ �ڷ������� ��������ȯ�ؼ� ���
		String imsi = (String)str;
		for(int k=0;k<imsi.length();k=k+1){
		}
		
	}
}
