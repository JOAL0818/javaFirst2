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
		setTitle("Ű�����̺�Ʈ");
		setLayout(null);
		
		Label air = new Label("@");
		air.setBounds(30,30,30,30);
		add(air);
		
		
		KeyListener KeyListener = new KeyListener() {
			//Ű���带 ������ �� ȣ��Ǵ� �޼ҵ�
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
				//Modifiers�� ���� ���� ����Ű ���� ����
				if(arg0.getModifiersEx()==KeyEvent.ALT_DOWN_MASK && arg0.getKeyCode()==KeyEvent.VK_F1) {
					System.exit(0);
				}	
				
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					Label label = new Label("��");
					label.setBounds(air.getLocation().x,air.getLocation().y-30,30,30);
					add(label);
				
					//�����带 ���� ����
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
										
					//�̷��� ������ ������� �ʰ� �̰��ϸ�, enterŰ ġ�� ���� 100�� ������ �ٸ� �����̰���
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}*/
			}			
			//Ű���忡�� ���� ���� �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void keyReleased(KeyEvent arg0) {
			}				
			//����Ű�� ������ �� ȣ��Ǵ� �޼ҵ�
			@Override
			public void keyTyped(KeyEvent arg0) {				
			}					
		};
		addKeyListener(KeyListener);

		
		
		//WindowListener����
		WindowAdapter windowListener = new WindowAdapter() {
			//�����ư�� ������ ȣ��Ǵ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {	
				//���α׷�����
				System.exit(0);
			}
		};
		
		//�����ӿ� ������ �̺�Ʈ ����
		addWindowListener(windowListener);
		
		setVisible(true);		
	}	
}