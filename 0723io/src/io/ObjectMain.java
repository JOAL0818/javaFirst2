/*package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectMain {

	public static void main(String[] args) {
		//��ü������ �����͸� ����� �� �ִ� Ŭ������ ������ ����
		ObjectInputStream ois = null;
		try {
			//���Ͽ� ��ü������ ����� �� �ִ� Ŭ������ ��ü�����
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));	
			
			//read�� �о�ö� Object Ÿ������ �����ϹǷ� ��������ȯ�� ���� ������ �ڷ������� �ǵ������Ѵ�.
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
		//��ü������ �����͸� ����� �� �ִ� Ŭ������ ������ ����
		ObjectInputStream ois = null;
		try {
			//���Ͽ� ��ü������ ����� �� �ִ� Ŭ������ ��ü�����
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));	
			
			//read�� �о�ö� Object Ÿ������ �����ϹǷ� ��������ȯ�� ���� ������ �ڷ������� �ǵ������Ѵ�.
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
		//��ü������ �����͸� ����� �� �ִ� Ŭ������ ������ ����
		ObjectOutputStream oos = null;
		try {
			//���Ͽ� ��ü������ ����� �� �ִ� Ŭ������ ��ü�����
			oos = new ObjectOutputStream(new FileOutputStream("./oos.txt"));	
			
			Member member = new Member();
			member.setEmail("jar0891@naver.com");
			member.setPw("0000");
			member.setPhone("01098159818");
			
			//��ü�� ���Ͽ� ��� - set,write�� ���� �׻� void
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
