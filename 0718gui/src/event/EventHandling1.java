package event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling1 extends Frame {
	//생성자
	public EventHandling1() {
		//위치와 크기설정
		setBounds(400,400,450,150);
		//제목설정
		setTitle("이벤트처리연습");
		
		//여러개를 배치하기 위해서 패널배치
		Panel panel = new Panel();
		
		TextField tf1 = new TextField(5);
		panel.add(tf1);
		Label plus = new Label("+");
		panel.add(plus);
		
		TextField tf2 = new TextField(5);
		panel.add(tf2);
		Label assign = new Label("=");
		panel.add(assign);
		
		TextField result = new TextField(6);
		panel.add(result);
		
		//버튼추가
		Button btn = new Button("계산");
		panel.add(btn);
		
		//ActionListener 인터페이스의 anonymous class생성
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//첫번째와 두번째 텍스트필드의 내용가져오기
				String n1 = tf1.getText();
				String n2 = tf2.getText();
				//문자열을 정수로 변환해서 더하기
				int r= Integer.parseInt(n1)+Integer.parseInt(n2);
				//숫자를 문자열로 만드는 방법 두가지! 아래 주석처리가 방식1, 그 아래줄이 방식2
				//result.setText(r+"");
				result.setText(String.format("%d", r));
			}			
		};		
		btn.addActionListener(listener);
		
		
		
		//비밀번호를 입력할때마다 무언가가 나온도록하는 이벤트
		Label lblPw = new Label("비밀번호");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwResult = new Label();
		panel.add(pwResult);
		
		//텍스트필드의 내용이 변경될때 처리할 수 있는 인터페이스의 인스턴스 생성
		TextListener t1 = new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				//password를 가지고 왔다.
				String password = pw.getText();
				//영문대소문자, 숫자, 특수문자 개수세기
				int dae=0;
				int so=0;
				int su=0;
				int etc = 0;
				//password의 모든 글자를 순회
				for(int i=0; i<password.length();i=i+1) {
					//i번째 글자가져오기 
					char ch = password.charAt(i);
					//대문자인지 확인 : A-Z
					if(ch>='A'&& ch<='Z') {
						dae=dae+1;
					}
					else if(ch>='a'&& ch<='z') {
							so=so+1;
					}
					else if(ch>='0'&& ch<='9') {
							su=su+1;
					}
					else{
						etc=etc+1;
					}
				}
				//4개 중에 한개라도 종류에 해당이 안되면  
				if(dae*so*su*etc>0) {
					pwResult.setBackground(Color.YELLOW);
					pwResult.setText("사용가능한 비밀번호");
				}
				else{
					pwResult.setBackground(Color.RED);
					pwResult.setText("비밀번호가 너무 약해요");
				}				
			}		
		};
		pw.addTextListener(t1);
		
		add(panel);		
		//화면출력
		setVisible(true);		
	}
}