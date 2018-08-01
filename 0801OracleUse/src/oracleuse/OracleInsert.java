package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OracleInsert {

	public static void main(String[] args) {
		Connection con = null;
		//SQL실행변수
		PreparedStatement pstmt = null;
		try {
			//드라이버클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
			//SQL실행객체 생성
			//pstmt = con.prepareStatement("insert into dept(deptno,dname,loc)"+"values(100,'영업','부산')");
			//pstmt = con.prepareStatement("delete from dept where deptno = 50");
			pstmt = con.prepareStatement("update dept set loc='만재도' where deptno=10");
			
			//SQL실행 - select 제외한 구문실행
			//r에 저장되는 값 : 영향받은 행의 개수
			int r = pstmt.executeUpdate();
			//성공여부출력
			if(r>0) {
				System.out.println("삽입성공");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {		
			try {
				if(pstmt !=null) pstmt.close();
				if(con != null) con.close();				
				}catch(Exception e) {}
			}
		}
	}
