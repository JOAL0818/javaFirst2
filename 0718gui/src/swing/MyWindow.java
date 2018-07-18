package swing;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


//윈도우 클래스
public class MyWindow extends JFrame {
	public MyWindow() {
		//위치와 크기설정
		setBounds(100,100,1000,1000);
		//제목설정
		setTitle("스윙을 이용한 윈도우");
		//종료버튼이벤트처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//패널을 생성
		JPanel panel = new JPanel();	
		ImageIcon icon =new ImageIcon("C:\\Users\\503-01\\Desktop\\2.PNG");	
		JLabel label = new JLabel(icon); //이거 대신 아래두줄 사용해도 된다.
		//JLabel label = new JLabel(); 
		//label.setIcon(icon);
		
	
		label.setToolTipText("안녕하세요");
		TitledBorder border = new TitledBorder("경계선");
		label.setBorder(border);
		
		/*EtchedBorder border = new EtchedBorder(Color.BLACK, Color.PINK);
		label.setBorder(border);*/
		panel.add(label);
		
		//버튼생성
		JButton btn =new JButton("버튼");
		panel.add(btn);
		
				
		//패널을 프레임에 부착
		add(panel);
		//화면출력
		setVisible(true);
		
		
		//방법1,2 중에서 사용
		//방법1)그림파일 이름을 배열로 만들기 - 배일이니까 크기변경불가
		String [] images = {"3.png","4.png","5.png"};
		
		//방법2)그림파일 List로 만들기 - 크기변경가능
		ArrayList<String> list = new ArrayList<String>();
		list.add("3.png");
		list.add("4.png");
		list.add("5.png");
				
		//스레드생성 : 이미지 변경되는 동안에도 다른작업이 진행될 수 있도록
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while(true) {
					try {
						Thread.sleep(1000);
						//배열을 이용하는 경우
						//ImageIcon icon= new ImageIcon("C:\\Users\\503-01\\Desktop\\"+images[idx%images.length]);//항상 0,1,2만가능
						//label.setIcon(icon);
						
						//List를 이용하는경우
						ImageIcon icon=new ImageIcon("C:\\Users\\503-01\\Desktop\\"+list.get(idx%list.size()));
						label.setIcon(icon);
						
						idx=idx+1;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
	}
}