package bytestream;

import java.io.FileOutputStream;
import java.io.PrintStream;


public class PrintStreamMain {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("./data.dat")); //파일이름 뒤 ,true하면 기존내용에 추가가 된다.
			ps.println("안녕하세요.");
			ps.println("바로바로 처리합니다.");
			ps.flush();
		}catch(Exception e){
			System.out.println("파일쓰기 예외:"+e.getMessage());
			
		}finally{
			if(ps !=null)
			ps.close();
			
		}
	}
}
