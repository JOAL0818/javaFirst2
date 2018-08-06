import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		//문자열 배열생성
		String [] ar = {"아이린","배수지","김태연"};
		
		//문자열 리스트를 생성
		List<String>person = new ArrayList<String>();
		person.add("남자현");
		person.add("홍범도");
		person.add("김원봉");
		person.add("장준하");
		
		//문자열 배열을 가지고 스트림만들기
		Stream<String> stream = Arrays.stream(ar);
		//작업수행
		stream.forEach(name -> {System.out.println(name);});	
		System.out.println("=============");
		//List를 가지고 스트림만들기
		stream = person.stream();
		stream.forEach(name->{System.out.println(name);});
	}
}
