package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddressBook extends JFrame {
	// �÷��̸��迭
	String[] columns = { "�̸�", "�������", "��ȭ��ȣ" };

	// �����͹迭
	String[][] data = { { "���Ͽ�", "920419", "������߶���" }, { "������", "900327", "��������α�" }, { "������", "900829", "������߱�" },
			{ "�̼���", "900515", "����ø�����" }, };

	public AddressBook() {
		setBounds(100, 100, 900, 200);
		setTitle("����ó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ���̺� �𵨸����
		DefaultTableModel model = new DefaultTableModel(data, columns);

		// ���̺� ���� �̿��ؼ� ���̺� ����� ���1)
		JTable table = new JTable(model);
		// table.setModel(model); // ������ ���߿� ���鶧, ���̺� ����� ���2)

		// ��¿����� ũ�⺸�� table�� Ŀ������ ��ũ�ѹٸ� �̿��� �� �ֵ��� Scroll����
		JScrollPane scrollPane = new JScrollPane(table);
		// ��ũ�������� �����ӿ� ����
		add(scrollPane);
		
				
		JLabel lblName = new JLabel("�̸�");
		JTextField tfName = new JTextField(10);
		JLabel lblBirth = new JLabel("�������");
		JTextField tfBirth = new JTextField(15);
		JLabel lblAddress = new JLabel("�ּ�");
		JTextField tfAddress = new JTextField(30);
	
		JButton btnInsert = new JButton("����");
		JButton btnDelete = new JButton("����");
				
		JPanel southPanel=new JPanel();
		southPanel.add(lblName);
		southPanel.add(tfName);
		southPanel.add(lblBirth);
		southPanel.add(tfBirth);
		southPanel.add(lblAddress);
		southPanel.add(tfAddress);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);
		
		add("South",southPanel);
		setVisible(true);
		
		
		//���Թ�ư�� Ŭ���̺�Ʈ - ActionListeneró��
		ActionListener insertListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�ؽ�Ʈ �ʵ忡 �Էµ� ���밡������
				String name = tfName.getText();
				String birth = tfBirth.getText();
				String address = tfAddress.getText();
				
				//��ȿ���˻�-�¿��������
				name = name.trim();
				birth = birth.trim();
				address = address.trim();
				//��ȿ���˻�-name�ʼ��Է�
				//�̸��� �Էµ��� ���� ��� (length)���̰� 0 - null�� �ƴϾ�!
				if(name.length()==0) {
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ��Է�", "�̸�", JOptionPane.WARNING_MESSAGE);
				//�Ʒ����� ���̻� �������� �ʵ��� ����
				return;
				}
										
				//���̺��� �����͸� �����ϱ� ���� ���̺��� ������ ���� �����´�.
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				//�����͸� �߰��ϱ� ���� �߰��� ������ �迭�� ����
				String[] row = {name,birth,address};
				//�𵨿� �߰�
				model.addRow(row);
				//���̺� ����
				table.updateUI();		
				
				//�ؽ�Ʈ �ʵ� Ŭ����
				tfName.setText("");
				tfBirth.setText("");
				tfAddress.setText("");
				//�޽��� �ڽ����
				JOptionPane.showMessageDialog(null, "�������Է¼���", "�Է��۾�", JOptionPane.PLAIN_MESSAGE);
			}			
		};
		btnInsert.addActionListener(insertListener);
		
		
		
		//������ư�� Ŭ���̺�Ʈ - ActionListeneró��
		ActionListener deleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ ���ȣ ã��
				int idx = table.getSelectedRow(); 
				//���̺��� ���� �������� �ʾѴٸ� 
				if(idx<0||idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "���������ϼ���", "��������", JOptionPane.WARNING_MESSAGE);
					//�Ʒ����� ���̻� �������� �ʵ��� ����
					return;
				}
				
				//���̺��� �𵨰�������
				DefaultTableModel model =(DefaultTableModel)table.getModel(); 
				//���õ� �࿡ �ش��ϴ� �����������
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null, "�����ͻ���", "����", JOptionPane.WARNING_MESSAGE);
			}			
		};
		btnDelete.addActionListener(deleteListener);
			
		
		
		
		// �޴��� ����
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("����(a)"); //����Ű����
		file.setMnemonic('a');

		JMenuItem item1 = new JMenuItem("����");
		file.add(item1);
		JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("����");
		file.add(item2);
		JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("����");
		file.add(item3);

		menuBar.add(file);

		setJMenuBar(menuBar);  // �޴��ٸ� �����쿡 ����

			
		
		// JOptionPane
		// MessageDialog �޽��� ���̾�α� ���
		//JOptionPane.showMessageDialog(null,"�޽������̾�α�","��ȭ����",JOptionPane.QUESTION_MESSAGE);

		// ConfirmDialog ���ô��̾�α����
		//int r = JOptionPane.showConfirmDialog(null, "�޽������̾�α�", "��ȭ����", JOptionPane.YES_NO_OPTION);
		//System.out.println(r);

		// InputDialog �����Է¹޴� ���̾�α� ���
		// String r = JOptionPane.showInputDialog(null,"�޽������̾�α�","��ȭ����",JOptionPane.YES_NO_OPTION);
		// System.out.println(r);

	}
}
