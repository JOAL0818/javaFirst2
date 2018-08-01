import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnectionMain {
	public static void main(String[] args) {
		//사용하고자 하는 드라이버 클래스를 로드 - DB종류에 따라 다르다
		
		//데이터베이스 연결변수 선언 - 반드시 close()호출해야하므로 finally에서 close()호출
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.229:1521:xe","scott", "tiger");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			//연결이 되어 있으면 반드시 연결해제
			if(con != null) {
				try {
					con.close();
				}catch(Exception e) {}
			}
		}
	}
}
