package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class logfileread {
	public static void main(String[] args) {
		//1.BufferedReader ��ü(Instance) �����
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./access_log.txt"));		
			//�� ������ ������ �о ���			
			HashMap<String,Integer> map = new HashMap<>();
			
			//HashMap�� �̿��ؼ� ������ IP �� Ʈ���� �հ����
			HashMap<String,Integer> traffic = new HashMap<>();
			
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				String [] ar = line.split(" ");
				//ip�� ����� �����͸� �����ɴϴ�.
				Integer count = map.get(ar[0]);
				//����� �����Ͱ� ������ 1�� ����
				if(count==null) {
					map.put(ar[0], 1);					
				}
				//����� �����Ͱ� ������ 1�� ���ؼ� ����
				else {
					map.put(ar[0],count+1);					
				}
				
				Integer traf = traffic.get(ar[0]);
				if(traf==null) {
					if(!ar[9].equals("\"-\"")&&!ar[9].equals("-")){
						traffic.put(ar[0],Integer.parseInt(ar[9]));
					}
				}else {
					if(!ar[9].equals("\"-\"")&&!ar[9].equals("-")){
						traffic.put(ar[0],traf+Integer.parseInt(ar[9]));
					}
				}
					
				//���� ��� �����͸� ���
				Set<String> keySet = map.keySet();
				for(String key : keySet) {
					System.out.println(key+":"+map.get(key));
				}			
				
				System.out.println("-----------------------");
				keySet = traffic.keySet();
				for(String key : keySet) {
					System.out.println(key+":"+traffic.get(key));
				}			
			}			
		}catch(Exception e) {
			System.out.println("����"+e.getMessage());
		}finally {			
			try {
				if(br!=null)
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
