import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain2 {

	public static void main(String[] args) {
		String [] ar = {"김좌진","김원봉","남자현","안중근","신채호","안창호","홍범도","윤봉길","안중근"};
		//스트림 변환
		Stream<String> stream = Arrays.stream(ar);
		//모든데이터 출력
		//stream.forEach(name->{System.out.println(name);});
		
		//stream 중간연산 - 중복제거
		//stream.distinct().forEach(name ->{System.out.println(name);});
		
		//중간처리메소드 여러개 사용가능
		//stream.distinct().skip(2).limit(3).forEach(name ->{System.out.println(name);});
	
		//김으로 시작하는 데이터만 찾아서출력	
		//방1)
//	    stream.filter(name -> {if (name.startsWith("김")) return true; else return false;
//	     }).forEach(name -> {System.out.println(name);
//	     });
//	    //방2)
	    //stream.filter(name ->name.startsWith("김")).forEach(name->System.out.println(name));
	    //또다른 예시
	    stream.filter(name -> name.length() !=3).forEach(name -> System.out.println(name));
	
	
	}

}