import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	// StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
	public List<StudentVO> fetch(){
		//리턴할 리스트생성
		//List를 리턴해야 하는 경우에는 null을 리턴하지 않는게 좋다.
		//why? List는 특별한 경우가 아니면 빠른열거를 이용해서 접근하는데, null이면 NullPointerException이 발생
		//null을 만들지 않기위해 인스턴스를 생성해서 리턴한다.
		List<StudentVO> list = new ArrayList<StudentVO>();
		
		
		 Connection con = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null; 
	      try {
	    	  //드라이버클래스로드
	          Class.forName("oracle.jdbc.driver.OracleDriver");
	          //데이터베이스연결
	          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	          //SQL실행객체 생성
	          pstmt = con.prepareStatement("select num,name,subject,score,age,gender from student");
	          //SQL실행
	          rs=pstmt.executeQuery();
	          while(rs.next()) {
	        	  StudentVO vo = new StudentVO(rs.getString("num"),rs.getString("name"),rs.getString("subject")
	        			  						,rs.getInt("score"),rs.getInt("age"),rs.getString("gender"));
	        	  list.add(vo);
	          }      
	      }catch(Exception e) {
	    	   //예외내용확인을위해서작성
	           System.out.println("읽기오류:"+e.getMessage());
	           //예외의 위치를 알기위해서 작성
	           e.printStackTrace();
	      }finally{
	          try {
	        	  //생성순서의 반대순서로 닫아줘야한다. 
	                if(rs !=null)rs. close();
	                if(pstmt !=null)pstmt.close();
	                if(con != null)con.close();
	           }catch(Exception e) {}   
		
	      }
		return list;
	}
	
}
