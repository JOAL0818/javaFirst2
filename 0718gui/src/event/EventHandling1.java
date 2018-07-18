package event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class EventHandling1 extends Frame {
	//������
	public EventHandling1() {
		//��ġ�� ũ�⼳��
		setBounds(400,400,450,150);
		//������
		setTitle("�̺�Ʈó������");
		
		//�������� ��ġ�ϱ� ���ؼ� �гι�ġ
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
		
		//��ư�߰�
		Button btn = new Button("���");
		panel.add(btn);
		
		//ActionListener �������̽��� anonymous class����
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ù��°�� �ι�° �ؽ�Ʈ�ʵ��� ���밡������
				String n1 = tf1.getText();
				String n2 = tf2.getText();
				//���ڿ��� ������ ��ȯ�ؼ� ���ϱ�
				int r= Integer.parseInt(n1)+Integer.parseInt(n2);
				//���ڸ� ���ڿ��� ����� ��� �ΰ���! �Ʒ� �ּ�ó���� ���1, �� �Ʒ����� ���2
				//result.setText(r+"");
				result.setText(String.format("%d", r));
			}			
		};		
		btn.addActionListener(listener);
		
		
		
		//��й�ȣ�� �Է��Ҷ����� ���𰡰� ���µ����ϴ� �̺�Ʈ
		Label lblPw = new Label("��й�ȣ");
		panel.add(lblPw);
		TextField pw = new TextField(15);
		panel.add(pw);
		Label pwResult = new Label();
		panel.add(pwResult);
		
		//�ؽ�Ʈ�ʵ��� ������ ����ɶ� ó���� �� �ִ� �������̽��� �ν��Ͻ� ����
		TextListener t1 = new TextListener() {
			@Override
			public void textValueChanged(TextEvent e) {
				//password�� ������ �Դ�.
				String password = pw.getText();
				//������ҹ���, ����, Ư������ ��������
				int dae=0;
				int so=0;
				int su=0;
				int etc = 0;
				//password�� ��� ���ڸ� ��ȸ
				for(int i=0; i<password.length();i=i+1) {
					//i��° ���ڰ������� 
					char ch = password.charAt(i);
					//�빮������ Ȯ�� : A-Z
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
				//4�� �߿� �Ѱ��� ������ �ش��� �ȵǸ�  
				if(dae*so*su*etc>0) {
					pwResult.setBackground(Color.YELLOW);
					pwResult.setText("��밡���� ��й�ȣ");
				}
				else{
					pwResult.setBackground(Color.RED);
					pwResult.setText("��й�ȣ�� �ʹ� ���ؿ�");
				}				
			}		
		};
		pw.addTextListener(t1);
		
		add(panel);		
		//ȭ�����
		setVisible(true);		
	}
}