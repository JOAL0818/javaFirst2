package event;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventHandling2 extends Frame {
	public EventHandling2() {
		setBounds(100,100,500,500);
		setTitle("키보드이벤트");
		setLayout(null);
		
		Label air = new Label("@");
		air.setBounds(30,30,30,30);
		add(air);
		
		
		KeyListener KeyListener = new KeyListener() {
			//키보드를 눌렀을 때 호출되는 메소드
			@Override
			public void keyPressed(KeyEvent arg0) {
				int x = air.getLocation().x;
				int y = air.getLocation().y;
				if(arg0.getKeyCode()==arg0.VK_LEFT) {
					x=x-10;
				}
				if(arg0.getKeyCode()==arg0.VK_RIGHT) {
					x=x+10;
				}
				if(arg0.getKeyCode()==arg0.VK_UP) {
					y=y-10;
				}
				if(arg0.getKeyCode()==arg0.VK_DOWN) {
					y=y+10;
				}					
				air.setLocation(x,y);	
				//Modifiers는 같이 누른 조합키 값을 리턴
				if(arg0.getModifiersEx()==KeyEvent.ALT_DOWN_MASK && arg0.getKeyCode()==KeyEvent.VK_F1) {
					System.exit(0);
				}	
				
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					Label label = new Label("↑");
					label.setBounds(air.getLocation().x,air.getLocation().y-30,30,30);
					add(label);
				
					//스레드를 만들어서 실행
				Thread th = new Thread() {
					public void run() {
						try {
							while(true) {
							Thread.sleep(10);
							int x = label.getLocation().x;
							int y = label.getLocation().y;
							label.setLocation(x,y-5);
								if(y<50) 
									break;
						}	
						label.setVisible(false);
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}		
					}
				};
				th.start();			
				}
				
				
				/*
				 if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {			
				 
					Thread th = new Thread() {
						public void run() {
							try {
								Thread.sleep(100000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					};
										
					//이렇게 스레드 사용하지 않고 이걸하면, enter키 치는 순간 100초 지나야 다른 실행이가능
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}*/
			}			
			//키보드에서 손을 뗐을 때 호출되는 메소드
			@Override
			public void keyReleased(KeyEvent arg0) {
			}				
			//문자키를 눌렀을 때 호출되는 메소드
			@Override
			public void keyTyped(KeyEvent arg0) {				
			}					
		};
		addKeyListener(KeyListener);

		
		
		//WindowListener구현
		WindowAdapter windowListener = new WindowAdapter() {
			//종료버튼을 누를때 호출되는 메소드
			@Override
			public void windowClosing(WindowEvent e) {	
				//프로그램종료
				System.exit(0);
			}
		};
		
		//프레임에 윈도우 이벤트 연결
		addWindowListener(windowListener);
		
		setVisible(true);		
	}	
}