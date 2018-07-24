package url;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLFileDownload {

	public static void main(String[] args) {
		try {
			//�ٿ�ε� ���� �ּҸ����
			String addr = "http://www.onlifezone.com/files/attach/images/962811/376/321/005/2.jpg";
			//addr���� ������ , ������ ���ڿ� ��������
			//������ /�� ��ġ�� ã���ϴ�.
			int idx = addr.lastIndexOf("/");
			//addr���� idx+1��° ���ں��� ��������
			String filename = addr.substring(idx+1);
			//System.out.println(filename);  //����� �߷ȴ��� Ȯ��
			
			//filename�� �̿��ؼ� ������ ���� ��θ����
			String filepath = "C:\\Users\\503-01\\Documents\\���ƶ�"+filename;
			//������ �����ϴ��� Ȯ��
			if((new File(filepath)).exists()) {
				System.out.println("�̹������� �����մϴ�.");
			}else {
				//System.out.println("������ �������� �ʽ��ϴ�."); //������ ���翩�� Ȯ��
				
				//������ ��ü����
				Thread th = new Thread() {
					public void run() {
						try {
							//�ٿ�ε� ����  URL�����						
							URL url = new URL(addr);
							//���ᰴü����
							HttpURLConnection con = (HttpURLConnection)url.openConnection();
							//�ɼǼ���
							con.setConnectTimeout(2000);
							con.setUseCaches(false);
							//����Ʈ ������ �ٿ�ε� �ޱ����� ��Ʈ������
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							//�ٿ�ε� ���� ������ ����� ��Ʈ��
							PrintStream ps = new PrintStream(filepath);
							
							while(true) {
								byte[] b = new byte[512];
								int r = bis.read(b);
								if(r<=0) {
									break;
								}
								ps.write(b,0,r);
							}			
							//���� ��������� ����
							ps.close();
							bis.close();
							con.disconnect();
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
				};
				//������ ����
				th.start();
			}			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
