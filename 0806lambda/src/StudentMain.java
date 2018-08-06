import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentMain {

	public static void main(String[] args) {
		
//		Student student = new Student();
//		student.setName("강감찬");
//		student.setGender("남자");
//		student.setAge(24);
//		student.setScore(97);
//		student.setSubject("사회체육학과");		
//		//순서를 기억하는건 어렵지만, 한번에 만들수 있다는 점이 장점이다.
//		Student student1 = new Student("남자현","여자",92,25,"전자계산학과");
		
		
		//Student 클래스의 인스턴스의 배열
		Student [] ar = new Student[5];
		ar[0] = new Student("을지문덕","남자",98,24,"컴퓨터공학과");
		ar[1] = new Student("권유리","여자",75,30,"조리학과");
		ar[2] = new Student("이지연","여자",99,25,"컴퓨터공학과");
		ar[3] = new Student("강수지","여자",88,20,"지리학과");
		ar[4] = new Student("최재성","남자",69,35,"체육학과");
		
		//성별이 남자인 데이터만 출력 
//		Stream <Student> stream = Arrays.stream(ar);
//		stream.filter(student -> student.getGender().equals("남자"))
//		.forEach(student -> System.out.println(student));
		
		//성별이 여자이고 나이가 30이상인 데이터 : &&사용하면 여러조건도 가능
//		Stream <Student> stream = Arrays.stream(ar);
//		stream.filter(student -> student.getGender().equals("여자")&&student.getAge()>=30)
//		.forEach(student -> System.out.println(student));
		
		//Student를 score로 변경
//		Stream<Student> stream = Arrays.stream(ar);
//		stream.mapToInt(Student::getScore).forEach(student -> System.out.println(student));
	
		
		//매개변수가 없는 sorted()
//		int [] array = {30,20,31,78,12};
//		IntStream stream = Arrays.stream(array);
//		stream.sorted().forEach(su -> System.out.println(su));
		
		//매개변수가 있는 sorted()
//		String []insa = {"Morning","Afternoon","Evening","Night"};
		//문자열의 배열을 정렬해서 출력
//		Stream<String> s = Arrays.stream(insa);
//		s.sorted((n1,n2)->n2.compareTo(n1)).forEach(su -> System.out.println(su));
	
		
		//맨 위 배열 이름 오름차순
		Stream<Student> stream = Arrays.stream(ar);
		stream.sorted((n1,n2)->n1.getName().compareTo(n2.getName())).forEach(student -> System.out.println(student));
		
		
		//맨 위 배열 나이로 내림차순
//		Stream<Student> stream = Arrays.stream(ar);
//		stream.sorted((n1,n2)->n2.getAge()-n1.getAge()).forEach(student -> System.out.println(student));

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
