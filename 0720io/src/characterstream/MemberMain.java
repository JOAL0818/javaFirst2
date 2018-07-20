package characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {
		//Ű����� ���� �ٴ����� �Է� ���� �� �ִ� Ŭ������ ������ ��������
		//final������ close�� �� �ֵ��� try�ۿ��� ��������
		BufferedReader br = null;
		try {
			//VO class�̿�
			//Ű����� �Է¹��� �� �ִ� �ν��Ͻ� ���� 
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�̸�:");
			//���ڿ� ���� �о����
			String name = br.readLine();			
			System.out.print("����:");
			String age = br.readLine();
			System.out.print("Ű:");
			String height = br.readLine();
			
			//3���� �����͸� �ϳ��� �����ϱ� ���� �ν��Ͻ��� ����
			Member member =new Member();
			member.setName(name);
			//�Է¹��� ���ڿ��� ������ ��ȯ�ؼ� ����
			member.setAge(Integer.parseInt(age));
			//�Է¹��� ���ڿ��� �Ǽ��� ��ȯ�ؼ� ����
			member.setHeight(Double.parseDouble(height));
			
			
			//���� �̿��ؼ� ����
			Map<String,Object> map = new HashMap<>();
			map.put("name", name);
			map.put("age", Integer.parseInt(age));
			map.put("height", Double.parseDouble(height));
			
			
			
			//����Ҷ��� VOŬ������ Map�̳� �� ���̰� �����ϴ�.
			System.out.println(member);
			System.out.println(map);
			
			//����Ҷ��� ���� �ٸ��� ��)���̸� 1�� ���Ҷ�
			//VOŬ���� �̿��Ҷ��� �׳� �����ͼ� ���ָ� �ȴ�.
			//Map�� ��쿡�� �����͸� �����ͼ� ��������ȯ�� �ؾ��մϴ�.
			int r= member.getAge()+1;
			r=(Integer)map.get("age")+1;
		
			
		}catch(Exception e) {
			System.out.println("����:"+e.getMessage());
		}finally {
			if(br !=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}		
	}
}
