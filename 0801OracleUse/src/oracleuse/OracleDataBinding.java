package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding {

	public static void main(String[] args) {
		//데이터베이스연결변수
		Connection con = null;
		//SQL실행변수
		PreparedStatement pstmt = null;
		
		//키보드로부터 입력을 받을 수 있는 객체생성
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호");
		int deptno = sc.nextInt();
		System.out.println("부서이름");
		//이전에 남아있던 Enter를 제거하기 위한 코드 : 안적어주면 부서이름입력불가
		sc.nextLine();
		String dname = sc.nextLine();
		System.out.print("지역");
		String loc = sc.nextLine();		
		sc.close();
		
		try {
			// 드라이버클래스로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			//pstmt 생성
			pstmt = con.prepareStatement("insert into dept(deptno, dname, loc)"+ "values(?,?,?)");
			//데이터바인딩
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int r = pstmt.executeUpdate();
			if(r>0) {
				System.out.println("삽입성공");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
}
