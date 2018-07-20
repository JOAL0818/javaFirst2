package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamMain {

	public static void main(String[] args) {
		//try-catch-finally는 각각의 블럭이다. (close제대로!!-파일입출력/scanner/네트워크/데이터베이스 주의!)
		FileOutputStream fos = null;
		try {
			//예외가 발생할 가능성이 있는 구문
			//현재 프로젝트 디렉토리에 파일을 생성
			fos = new FileOutputStream("C:\\Users\\503-01\\Desktop\\0720byte.txt",true);   //   ./는 현재 디렉토리라는 의미
																						   // 파일제목옆에 ,true 적으면 기존데이터에 추가
			
			//기록하는 방법 3가지
			//1)파일에 1바이트씩 기록하는방법
			fos.write(66);			
			//2)파일에 바이트배열을 기록
			byte [] ar = {97,98,65,66};
			fos.write(ar);			
			//3)문자열을 바이트 배열로 변환해서 기록 : getBytes 이용 - 중요!!!
			String str = " 안녕하세요";
			fos.write(str.getBytes());
			
			
			//버퍼의 내용비우기
			fos.flush();
		}catch(Exception e) {
			//예외가 발생했을 때 수행할 구문
			System.out.println("파일 입출력예외:"+e.getMessage());
			//현재날짜와 시간,예외내용을 로깅 - 파일에 기록하거나 네트워크를 통해서 서버에 전달
			//모든 프로그램 만들때 고려해야할 사항!
		}finally {
			//예외발생여부에 상관없이 수행할 구문
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
			
			
			//1byte 읽어오기
			//int r = fis.read();
			//System.out.println(r); //문자로 출력하고 싶으면 char로 형변환 해야한다. 
			
			//4바이트 읽어오기 
			//byte [] b = new byte[4];
			//fis.read(b);
			//System.out.println(b); //B@299a06ac : 배열은 toString이 재정의 돼있지 않아 해시코드가 출력된다
			
			//4바이트씩 전체읽기 - read에 바이트 배열을 대입하면 읽은 개수를 리턴 
			//0보다 작거나 같은 값을 리턴하면 읽을 데이터가 없는것
			while(true) {
				byte [] b = new byte[4];
				int r = fis.read(b);
				//System.out.println(b1); //배열은 toString이 재정의 돼있지 않아 해시코드가 출력
				
				//코드를 각각 출력
				for(byte imsi :b) {
					//System.out.println(imsi);
				}
				
				//문자열로 변환해서 출력
				System.out.println(new String(b));
				if(r<=0) {
					break;
				}
			}
					
		}catch(Exception e) {
			System.out.println("파일읽기예외:"+e.getMessage());
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
