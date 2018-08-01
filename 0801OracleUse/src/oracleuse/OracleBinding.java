package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleBinding {
	public static void main(String[] args) {
		//1.정수를 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 부서번호(정수):");
		int deptno = sc.nextInt();
		System.out.println("부서번호" + deptno);
		sc.close();
		
		
		//2.입력받은 데이터를 이용해 데이터베이스에서 삭제
		//필요한변수선언
		// 데이터베이스연결변수
		Connection con = null;
		// SQL실행변수
		PreparedStatement pstmt = null;

		try {
			// 드라이버클래스로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("fhem성공");
			
			// DB연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			System.out.println("연결성공");
			
			//autocommit해제
			con.setAutoCommit(false);
			
			//SQL실행객체 생성
			pstmt = con.prepareStatement("delete from dept where deptno=?");
			pstmt.setInt(1, deptno);
			
			//SQL실행
			int r = pstmt.executeUpdate();
			//실행후, 영향받은 행의 개수 리턴
			//조건에 맞는 데이터가 없으면 실패X -> 삭제하는 행의 개수가 0이다. cf)실패할때, 예외발생 : catch로간다
			if (r > 0) {
				System.out.println("삭제성공");
				//작업에 성공하면 commit호출
				con.commit();
			}else {
				System.out.println("조건에 맞는 데이터가 없습니다.");
			}
		
		} catch (Exception e) {
			try {
				//작업도중 예외가 발생한 경우 : rollback호출
				con.rollback();
			}catch(Exception e1) {}
			//catch구문을 적지 않으면 실패시 무엇이 잘못되었는지 알수x
			//예외내용 출력
			System.out.println(e.getMessage());
			//예외발생지점을 역추적
			e.printStackTrace();
			
		} finally {
			//닫아주지 않고 연결실행하면 100-150번 넘어가는 순간 실행X
			try {
				//나중에 실행한것 부터 닫아줘야한다.
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				
			} catch (Exception e) {
				//닫는거라 별다른 예외처리 할게 없으므로 비워둔다.
			}
		}
	}
}
