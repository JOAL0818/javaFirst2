package oracleuse;

import java.util.List;

public interface ContactDao {
	//데이터를 삽입하는 메소드
	public boolean insertContact (Contact contact);
	
	//데이터를 수정하는 메소드
	public boolean updateContact (Contact contact);
	
	//데이터를 삭제하는 메소드
	public boolean deleteContact (int num);

	//데이터 전체를 읽어오는 메소드
	//데이터는 0개 이상이므로 List로 리턴, 읽어올 컬럼들을 저장할 DTO 클래스나 Map으로 제너릭을 적용하면 된다.
	public List<Contact> allContact ();
	
	//원하는 데이터를 조회하기 위한 메소드
	//이름을 가지고 조회하는 메소드
	public List<Contact> nameContact (String name);
}
