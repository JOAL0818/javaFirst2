import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();
			
		//제대로 연결되었나 확인
		//방법1)
//		System.out.println(list);
		//└ 위처럼 한줄로 나오는게 보기 불편하다면 ┐
		//방법2)
		//출력하는 메소드에 인스턴스 이름을 대입하면 toString의 결과이다.
//		for(StudentVO vo:list) {
//			System.out.println(vo);
//		}

		
		//Stream생성
		Stream<StudentVO> stream = list.stream();
		
		//1.데이터 전부출력 : 위의 것에 비해 코드가 줄어든다.
		//stream.forEach(data -> System.out.println(data));
	
		
		//2.중간처리메소드활용
		//메소드 skip,limit 활용 : 데이터2개 건너띄고 3개출력
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		//메소드 filter활용 : 남자인 데이터만 출력
		//stream.filter(data -> data.getGender().equals("여자")).forEach(data -> System.out.println(data));
		//메소드 sorted활용 : 데이터 정렬
		//숫자일때 활용방법
		//stream.sorted((d1,d2)->d2.getScore()-d1.getScore()).forEach(data -> System.out.println(data));
		//문자열일때 활용방법
		//stream.sorted((d1,d2)->d2.getName().compareTo(d1.getName())).forEach(data -> System.out.println(data));
		//중간처리 메소드는 같이 사용할 수도 있다. 
		
		
		//3.최종처리메소드
		//count이용 : 데이터의 수를 세고싶다.
		//long cnt = stream.count();
		//최종처리메소드 : 걸러서 세고싶은경우
		//long cnt = stream.filter(data -> data.getGender().equals("여자")).count();		
		//System.out.println(cnt);
		
		//Optional로 리턴되는 데이터는 한번 더 가공을 해야한다.
//		StudentVO vo = stream.findFirst().get();
//		System.out.println(vo);
		
		//sum이용 : score의 합계구하기
		//숫자데이터가 아니면 바로 합계를 구할 수 없으므로 map메소드를 이용해 숫자데이터로 변경한 후 합계를 구해야한다.
		//int sum = stream.mapToInt(StudentVO::getScore).sum();
		//System.out.println("합계:"+sum);
		
		//average이용 :age평균구하기
//		double age = stream.mapToInt(StudentVO::getAge).average().getAsDouble();
//		System.out.println("나이평균:"+age);
		
		//average이용 : 성별이 남자인 데이터의 평균 점수를 구하는데 소수 1째자리에서 반올림해서 정수부분만 출력
//		double avg = stream.filter(data -> data.getGender().equals("남자"))
//						   .mapToInt(StudentVO::getScore).average().getAsDouble();
//		System.out.println(avg);
//		int score = (int)(avg+0.5); //반올림
//		System.out.println("남학생 평균점수:"+score);	
		
		//collect이용 : 성별이 여자인 데이터만 가지고 List생성
//		List<StudentVO> result = stream.filter(data -> data.getGender().equals("여자"))
//				                    .collect(Collectors.toList());
//		for(StudentVO vo: result) {
//			System.out.println(vo);
//		}		
		
		//이름과 점수만을 갖는 Map으로 생성
//		Map<String, Integer>map=stream.collect(Collectors
//						   			  .toMap(StudentVO::getName, StudentVO::getScore));  
//		System.out.println(map);
		//└람다이용하는 경우
//		Map<String, Integer>map=stream.collect(Collectors
//				                      .toMap(StudentVO::getName, data-> data.getScore()));  
//		System.out.println(map);
		
		//예제)성별이 남자이고 score가 90이상인 데이터의 List를 생성해서 출력
//		List<StudentVO> result = stream.filter(data -> data.getGender().equals("남자") &&data.getScore()>=90)
//									   .collect(Collectors.toList());
//		for(StudentVO vo: result) {
//			System.out.println(vo);
//		}				
		
		//collectors -> grouping by이용
		//groupingBy에 작성한 함수의 결과를 key로하고 원래 데이터의 List를 값으로 해서 Map으로 리턴
//		Map<String,List<StudentVO>> map = stream.collect(Collectors.groupingBy(StudentVO::getGender));
//		System.out.println(map);
		//대표값 종류별 출력
//		Map<String, IntSummaryStatistics> map =
//		stream.collect(Collectors.groupingBy(StudentVO::getGender,Collectors.summarizingInt(StudentVO::getScore)));
//		System.out.println(map);
		//collectors -> grouping by이용(매개변수로 집계함수 대입하는경우)
		//gender별 score합계 정수로 출력
		Map<String, Integer> map =
				stream.collect(Collectors.groupingBy(StudentVO::getGender,Collectors.summingInt(StudentVO::getScore)));
		System.out.println(map);
		//└map의 데이터 전부 출력하기 : 어떤 맵이라도 출력할 수 있다.(키를 몰라도)
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
				
				
		
	}
}
