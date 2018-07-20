package characterstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\503-01\\Documents\\조아라\\from공유폴더\\access_log.txt"));
			
			//List : 접속한 아이피를 중복에 상관없이 저장하기 위한 자료구조
			ArrayList<String> iplist = new ArrayList<>();
			//Set : 중복없이 저장하기위한 Set만들기
			Set<String>ipset = new HashSet<String>();
			
			while (true) {
				// 한줄을 읽기
				String line = br.readLine();
				// 읽은 데이터가 없으면 종료
				if (line == null) {
					break;
				}
				
				//읽은후, 공백으로 분할
				String [] ar = line.split(" ");
				System.out.println(ar[0]);
				//분할한것을 set에도 넣어보고 List에도 넣어보았다.
				iplist.add(ar[0]);
				ipset.add(ar[0]);				
			}	
			
			//출력해서 확인해보니 List는 중복된 것이 있고, set은 중복된 것이 없다.
			for(String ip : iplist) {
				System.out.println(ip);
			}
			//for(String ip : ipset) {
			//	System.out.println(ip);
			//}
			
			
		}catch (Exception e) {
			System.out.println("예외:" + e.getMessage());
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
