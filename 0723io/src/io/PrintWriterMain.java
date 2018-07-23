package io;

import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		//파일,네트워크,데이터베이스 관련 클래스들은 예외처리를 강제합니다. 
		PrintWriter pw = null;
		try {
			//현재 디렉토리에 파일을 생성
			pw = new PrintWriter("./file.txt");
			//파일에 문자열을 기록
			pw.println("안녕하세요 반갑습니다.");
			//마지막에 버퍼의 내용을 전부 출력 
			pw.flush();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pw!=null) {
				pw.close(); //예외처리 안해도 됨 - api통해서 close()메소드 참고
			}
		}
	}

}
