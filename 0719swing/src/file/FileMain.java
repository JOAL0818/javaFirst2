package file;

import java.io.File;
import java.util.Date;
public class FileMain {

	public static void main(String[] args) {
		//���Ͽ� ���� ������ Ȯ���� �� �մ� Ŭ������ �ν��Ͻ��� ����
		File f = new File("C:\\Users\\503-01\\Documents\\���ƶ�\\from��������\\15.IO.pptx");
		
		
		//������ ���翩��
		System.out.println(f.exists());
		
		
		//������ ũ��
		long size =f.length();
		System.out.println(size/1024+"K");
		
		
		//������ ���� �����ð�
		Date date = new Date(f.lastModified());
		System.out.println(date);
		
		
		//������ �̸�����
		File file = new File("C:\\Users\\503-01\\Documents\\���ƶ�\\from��������\\15.IO.pptx");
		System.out.println(file.getParent()); //���ϰ��
		System.out.println(file.getName());   //�����̸�
		String parent = file.getParent();
		String filename = file.getName();
		//filename���� 15.�� ������ �κ��� �������� 
		//.�� ��ġ�� ã�Ƽ� .������ ���ڿ��� �����´�. 
		//.�� �����Ѵٸ� ��ġ�� ã�� �޼ҵ�� ��ġ�� ��� / ã�����ϴ� �����Ͱ� ������ ������ ����
		int idx = filename.indexOf('.');
		System.out.println(idx); //��ġ�� ã�ƺ��Ҵ�. 
		int idx1 = filename.indexOf('k');  
		System.out.println(idx1);		//k�����ϱ� �������
		 
		//���ڿ��� ��ġ�� �ڸ��� �޼ҵ� -substring   cf)��ȣ�� ������ �ڸ����� split
		if(idx>=0) {
			filename = filename.substring(idx+1);
		}
		System.out.println(filename);
		//�̸��ٲٱ�
		String newFile = parent + filename;
		System.out.println(newFile);
		file.renameTo(new File(parent,filename));

	}

}
