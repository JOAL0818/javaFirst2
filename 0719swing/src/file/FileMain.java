package file;

import java.io.File;
import java.util.Date;
public class FileMain {

	public static void main(String[] args) {
		//파일에 대한 정보를 확인할 수 잇는 클래스의 인스턴스를 생성
		File f = new File("C:\\Users\\503-01\\Documents\\조아라\\from공유폴더\\15.IO.pptx");
		
		
		//파일의 존재여부
		System.out.println(f.exists());
		
		
		//파일의 크기
		long size =f.length();
		System.out.println(size/1024+"K");
		
		
		//파일의 최후 수정시간
		Date date = new Date(f.lastModified());
		System.out.println(date);
		
		
		//파일의 이름변경
		File file = new File("C:\\Users\\503-01\\Documents\\조아라\\from공유폴더\\15.IO.pptx");
		System.out.println(file.getParent()); //파일경로
		System.out.println(file.getName());   //파일이름
		String parent = file.getParent();
		String filename = file.getName();
		//filename에서 15.을 제거한 부분을 가져오기 
		//.의 위치를 찾아서 .이후의 문자열을 가져온다. 
		//.이 존재한다면 위치를 찾는 메소드는 위치를 출력 / 찾고자하는 데이터가 없으면 음수를 리턴
		int idx = filename.indexOf('.');
		System.out.println(idx); //위치를 찾아보았다. 
		int idx1 = filename.indexOf('k');  
		System.out.println(idx1);		//k없으니까 음수출력
		 
		//문자열을 위치로 자르는 메소드 -substring   cf)기호를 가지고 자를때는 split
		if(idx>=0) {
			filename = filename.substring(idx+1);
		}
		System.out.println(filename);
		//이름바꾸기
		String newFile = parent + filename;
		System.out.println(newFile);
		file.renameTo(new File(parent,filename));

	}

}
