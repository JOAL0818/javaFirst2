package oracleuse;

public class ContactMain {
	public static void main(String[] args) {
		new ContactView();
		
		
		
		
		
	}
}











/*

package oracleuse;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;


public class ContactMain {

	public static void main(String[] args) {
		//인터페이스나 클래스를 상속한 경우에는 상위인터페이스나 클래스이름으로 변수를 만들고
		//하위클래스의 인스턴스를 생성해서 대입한다.
//		ContactDao dao = new ContactDaoImpl();
//		Contact contact = new Contact();
//		contact.setNum(3);
//		contact.setName("조아롸롸");
//		contact.setPhone("01098150000");
//		contact.setEmail("jar0891@gmail.com");
//		//현재시간을 저장한 캘린더 생성
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR,2018);
//		cal.set(Calendar.MONTH,5);
//		cal.set(Calendar.DAY_OF_MONTH,19);
//		Date birthday = new Date(cal.getTimeInMillis());
//		contact.setBirthday(birthday);
		
		//데이터를 삽입하는 메소드호출
//		boolean result = dao.insertContact(contact);
//		if(result==true) {
//			System.out.println("삽입성공");
//		}else {
//			System.out.print("삽입실패");
//		}
//		
//		//데이터를 수정하는 메소드호출
//		boolean result1= dao.updateContact(contact);
//		if(result1==true) {
//			System.out.println("수정성공");
//		}else {
//			System.out.print("수정실패");
//		}
		
		//데이터를 삭제하는 메소드호출
//		boolean result2 = dao.deleteContact(contact.getNum());
//		if(result2==true) {
//			System.out.println("삭제성공");
//		}else {
//			System.out.print("삭제실패");
//		}

//-----------------------------------------------------------------------		
		//테이블 전체의 데이터를 읽고자한다.
		//인터페이스나 클래스를 상속한 경우에는 상위인터페이스나 클래스이름으로 변수를 만들고
		//하위클래스의 인스턴스를 생성하서 대입합니다.
//		ContactDao dao = new ContactDaoImpl();
//		List<Contact> list = dao.allContact();
//		//System.out.println(list);
//		for(Contact contact : list) {
//			System.out.println(contact);
//		}
		
//-----------------------------------------------------------------------		
		ContactDao dao = new ContactDaoImpl();
		List<Contact> list = dao.nameContact("롸");
		//System.out.println(list);
		for(Contact contact : list) {
			System.out.println(contact);
		}			
	}
}

*/