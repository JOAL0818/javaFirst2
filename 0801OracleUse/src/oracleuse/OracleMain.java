package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleMain {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// 사용하는 DB마다 로드하는 클래스이름은 결정되어 있다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 확인하기 위한 코드
			// └출력되지 않으면, 드라이버 이름 확인/referenced Libraries의 ojdbc6.jar보유 여부 확인
			System.out.println("오라클 드라이버 로드성공");

			// DB연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// DB제대로 연결됐는지 확인하는 코드
			// 출력되지 않으면 주소,계정확인
			System.out.println("데이터베이스 연결성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// DB열려있으면 닫기
				if (con != null) {
					con.close();
				}

			} catch (Exception e) {
			}
		}
	}
}
