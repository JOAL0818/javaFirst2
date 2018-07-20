package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamMain {

	public static void main(String[] args) {
		//try-catch-finally�� ������ ���̴�. (close�����!!-���������/scanner/��Ʈ��ũ/�����ͺ��̽� ����!)
		FileOutputStream fos = null;
		try {
			//���ܰ� �߻��� ���ɼ��� �ִ� ����
			//���� ������Ʈ ���丮�� ������ ����
			fos = new FileOutputStream("C:\\Users\\503-01\\Desktop\\0720byte.txt",true);   //   ./�� ���� ���丮��� �ǹ�
																						   // �������񿷿� ,true ������ ���������Ϳ� �߰�
			
			//����ϴ� ��� 3����
			//1)���Ͽ� 1����Ʈ�� ����ϴ¹��
			fos.write(66);			
			//2)���Ͽ� ����Ʈ�迭�� ���
			byte [] ar = {97,98,65,66};
			fos.write(ar);			
			//3)���ڿ��� ����Ʈ �迭�� ��ȯ�ؼ� ��� : getBytes �̿� - �߿�!!!
			String str = " �ȳ��ϼ���";
			fos.write(str.getBytes());
			
			
			//������ �������
			fos.flush();
		}catch(Exception e) {
			//���ܰ� �߻����� �� ������ ����
			System.out.println("���� ����¿���:"+e.getMessage());
			//���糯¥�� �ð�,���ܳ����� �α� - ���Ͽ� ����ϰų� ��Ʈ��ũ�� ���ؼ� ������ ����
			//��� ���α׷� ���鶧 ����ؾ��� ����!
		}finally {
			//���ܹ߻����ο� ������� ������ ����
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\503-01\\Desktop\\0720byte.txt");
			
			
			//1byte �о����
			//int r = fis.read();
			//System.out.println(r); //���ڷ� ����ϰ� ������ char�� ����ȯ �ؾ��Ѵ�. 
			
			//4����Ʈ �о���� 
			//byte [] b = new byte[4];
			//fis.read(b);
			//System.out.println(b); //B@299a06ac : �迭�� toString�� ������ ������ �ʾ� �ؽ��ڵ尡 ��µȴ�
			
			//4����Ʈ�� ��ü�б� - read�� ����Ʈ �迭�� �����ϸ� ���� ������ ���� 
			//0���� �۰ų� ���� ���� �����ϸ� ���� �����Ͱ� ���°�
			while(true) {
				byte [] b = new byte[4];
				int r = fis.read(b);
				//System.out.println(b1); //�迭�� toString�� ������ ������ �ʾ� �ؽ��ڵ尡 ���
				
				//�ڵ带 ���� ���
				for(byte imsi :b) {
					//System.out.println(imsi);
				}
				
				//���ڿ��� ��ȯ�ؼ� ���
				System.out.println(new String(b));
				if(r<=0) {
					break;
				}
			}
					
		}catch(Exception e) {
			System.out.println("�����б⿹��:"+e.getMessage());
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
