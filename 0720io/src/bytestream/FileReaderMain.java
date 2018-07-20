package bytestream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr= new FileReader("C:\\Users\\503-01\\Documents\\���ƶ�\\from��������\\0702.txt");
			char [] buf = new char[20];
			
			//buf�� ũ�⸸ŭ �о buf�� �����ϰ� ���� ������ r�� ����.
			while(true) {
				int r = fr.read(buf);
				if(r<=0) {
					break;
				}
				//�迭���� 0��°���� r��ŭ�� ���ڿ��� ��ȯ�ؼ� ���
				System.out.println(new String(buf,0,r));
			}
			
			
			//fr.read(buf);
			//�ѱ��ھ� �о�´�.
			//for(char ch : buf) {
			//	System.out.println(ch);
			//}
			
			//���ڿ��� �о�´�. - �ѹ���
			//System.out.println(new String(buf));
			
		} catch (Exception e) {
			System.out.println("����" + e.getMessage());

		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
