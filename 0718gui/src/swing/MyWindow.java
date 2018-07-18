package swing;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


//������ Ŭ����
public class MyWindow extends JFrame {
	public MyWindow() {
		//��ġ�� ũ�⼳��
		setBounds(100,100,1000,1000);
		//������
		setTitle("������ �̿��� ������");
		//�����ư�̺�Ʈó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�г��� ����
		JPanel panel = new JPanel();	
		ImageIcon icon =new ImageIcon("C:\\Users\\503-01\\Desktop\\2.PNG");	
		JLabel label = new JLabel(icon); //�̰� ��� �Ʒ����� ����ص� �ȴ�.
		//JLabel label = new JLabel(); 
		//label.setIcon(icon);
		
	
		label.setToolTipText("�ȳ��ϼ���");
		TitledBorder border = new TitledBorder("��輱");
		label.setBorder(border);
		
		/*EtchedBorder border = new EtchedBorder(Color.BLACK, Color.PINK);
		label.setBorder(border);*/
		panel.add(label);
		
		//��ư����
		JButton btn =new JButton("��ư");
		panel.add(btn);
		
				
		//�г��� �����ӿ� ����
		add(panel);
		//ȭ�����
		setVisible(true);
		
		
		//���1,2 �߿��� ���
		//���1)�׸����� �̸��� �迭�� ����� - �����̴ϱ� ũ�⺯��Ұ�
		String [] images = {"3.png","4.png","5.png"};
		
		//���2)�׸����� List�� ����� - ũ�⺯�氡��
		ArrayList<String> list = new ArrayList<String>();
		list.add("3.png");
		list.add("4.png");
		list.add("5.png");
				
		//��������� : �̹��� ����Ǵ� ���ȿ��� �ٸ��۾��� ����� �� �ֵ���
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while(true) {
					try {
						Thread.sleep(1000);
						//�迭�� �̿��ϴ� ���
						//ImageIcon icon= new ImageIcon("C:\\Users\\503-01\\Desktop\\"+images[idx%images.length]);//�׻� 0,1,2������
						//label.setIcon(icon);
						
						//List�� �̿��ϴ°��
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