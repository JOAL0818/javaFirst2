package characterstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MemberMain {

	public static void main(String[] args) {
		//키보드로 부터 줄단위로 입력 받을 수 있는 클래스의 참조형 변수선어
		//final절에서 close할 수 있도록 try밖에서 변수선언
		BufferedReader br = null;
		try {
			//VO class이용
			//키보드로 입력받을 수 있는 인스턴스 생성 
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름:");
			//문자열 한줄 읽어오기
			String name = br.readLine();			
			System.out.print("나이:");
			String age = br.readLine();
			System.out.print("키:");
			String height = br.readLine();
			
			//3개의 데이터를 하나로 저장하기 위한 인스턴스를 생성
			Member member =new Member();
			member.setName(name);
			//입력받은 문자열을 정수로 변환해서 저장
			member.setAge(Integer.parseInt(age));
			//입력받은 문자열을 실수로 변환해서 저장
			member.setHeight(Double.parseDouble(height));
			
			
			//맵을 이용해서 저장
			Map<String,Object> map = new HashMap<>();
			map.put("name", name);
			map.put("age", Integer.parseInt(age));
			map.put("height", Double.parseDouble(height));
			
			
			
			//출력할때는 VO클래스나 Map이나 별 차이가 없습니다.
			System.out.println(member);
			System.out.println(map);
			
			//사용할때는 조금 다르다 예)나이를 1씩 더할때
			//VO클래스 이용할때는 그냥 가져와서 해주면 된다.
			//Map의 경우에는 데이터를 가져와서 강제형변환을 해야합니다.
			int r= member.getAge()+1;
			r=(Integer)map.get("age")+1;
		
			
		}catch(Exception e) {
			System.out.println("예외:"+e.getMessage());
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
