import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;


public class Main {

	public static void main(String[] args) {
		  Connection con = null;
		  CallableStatement call = null;      
	      try {
	          Class.forName("oracle.jdbc.driver.OracleDriver");
	          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

	          /* call = con.prepareCall("{call insertDeptProc(?,?,?)}");
	          //물음표에 실제 값 바인딩
	         call.setInt(1, 13);
	         call.setString(2, "회계");
	         call.setString(3, "종로");        
	         //삽입구문실행
	         int r = call.executeUpdate();
	         if(r>0) {
	        	 System.out.println("삽입성공");
	         }else {
	        	 System.out.println("삽입실패");
	         }*/
	          
	         call = con.prepareCall("{call deleteDeptProc(?)}"); 
	         call.setInt(1, 13);	          	          
	         //삭제구문실행
	         int r = call.executeUpdate();
	         if(r>0) {
	        	 System.out.println("삭제성공");
	         }else {
	        	 System.out.println("삭제실패");
	         }
	         
	         	         
	      }catch(Exception e) {
	           System.out.println(e.getMessage());
	           e.printStackTrace();
	      }finally{
	          try {
	                if(call !=null)call.close();
	                if(con != null)con.close();
	           }catch(Exception e) {}   
	     }

	}

}
