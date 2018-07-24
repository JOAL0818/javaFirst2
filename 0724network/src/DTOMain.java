import java.util.ArrayList;
import java.util.Calendar;




public class DTOMain {

	public static void main(String[] args) {
		ArrayList<DTO> list = new ArrayList<>();
		Calendar birth = Calendar.getInstance();
		
		DTO dto = new DTO();
		dto.setNum(1);
		dto.setName("홍길동");
		dto.setScore(95);
		
		
		dto = new DTO();
		dto.setNum(4);
		dto.setName("이순신");
		dto.setScore(90);
		
		dto = new DTO();
		dto.setNum(2);
		dto.setName("강감찬");
		dto.setScore(75);
		
		dto = new DTO();
		dto.setNum(3);
		dto.setName("을지문덕");
		dto.setScore(66);
		
		dto = new DTO();
		dto.setNum(5);
		dto.setName("유관순");
		dto.setScore(100);
		
		

	}

}
