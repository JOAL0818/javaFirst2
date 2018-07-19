package swing;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.*;

//윈도우클래스 
public class MyWindow1 extends JFrame {
	String [] data = {
		"Encapsulation","Inheritance", "Polymorphism","Information Hiding"				
	};
	
	public MyWindow1() {
		setBounds(100,100,400,400);
		setTitle("스윙");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JList<String>list = new JList<>(data);
		JComboBox<String>combo = new JComboBox<>(data);
		JPanel p = new JPanel();
		p.add(list);
		p.add(combo);
		
		add(p);
		
		setVisible(true);
	}
}
