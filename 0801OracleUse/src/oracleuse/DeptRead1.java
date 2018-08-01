package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeptRead1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		//select구문의 결과를 저장하기위한 변수
		ResultSet rs = null;	
		try {
			// 드라이버클래스로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB연결
		    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		    //sql 실행객체생성
		    pstmt = con.prepareStatement("select deptno,dname,loc from dept");
		    //select 하는 sql실행
		    rs = pstmt.executeQuery();
		    //데이터 전체읽기
		    while(rs.next()) {
		    	System.out.print(rs.getInt("deptno")+":");
		    	System.out.print(rs.getString("dname")+":");
		    	System.out.print(rs.getString("loc")+"\n"); 	
		    }
		    
		    
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null)rs. close();
				if(pstmt !=null)pstmt.close();
				if(con != null)con.close();
			}catch(Exception e) {}			
		}
	}
}
