/*package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {

	public static void main(String[] args) {
		//객체단위로 데이터를 기록할 수 있는 클래스의 변수를 선언
		ObjectInputStream ois = null;
		try {
			//파일에 객체단위로 기록할 수 있는 클래스의 객체만들기
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));	
			
			//read로 읽어올때 Object 타입으로 리턴하므로 강제형변환을 통해 원래의 자료형으로 되돌려야한다.
			Member member = (Member)ois.readObject();
			System.out.println(member.getEmail());
			
		}catch(Exception e) {
				System.out.println(e.getMessage());
		}finally{
			if(ois !=null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}*/


package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {

	public static void main(String[] args) {
		//객체단위로 데이터를 기록할 수 있는 클래스의 변수를 선언
		ObjectInputStream ois = null;
		try {
			//파일에 객체단위로 기록할 수 있는 클래스의 객체만들기
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));	
			
			//read로 읽어올때 Object 타입으로 리턴하므로 강제형변환을 통해 원래의 자료형으로 되돌려야한다.
			Member member = (Member)ois.readObject();
			System.out.println(member.getEmail());
			
		}catch(Exception e) {
				System.out.println(e.getMessage());
		}finally{
			if(ois !=null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}


/*package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) {
		//객체단위로 데이터를 기록할 수 있는 클래스의 변수를 선언
		ObjectOutputStream oos = null;
		try {
			//파일에 객체단위로 기록할 수 있는 클래스의 객체만들기
			oos = new ObjectOutputStream(new FileOutputStream("./oos.txt"));	
			
			Member member = new Member();
			member.setEmail("jar0891@naver.com");
			member.setPw("0000");
			member.setPhone("01098159818");
			
			//객체를 파일에 기록 - set,write는 앞이 항상 void
			oos.writeObject(member);
			
		}catch(Exception e) {
				System.out.println(e.getMessage());
		}finally{
			if(oos !=null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}*/
