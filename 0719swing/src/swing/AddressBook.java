package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddressBook extends JFrame {
	// 컬럼이름배열
	String[] columns = { "이름", "생년월일", "전화번호" };

	// 데이터배열
	String[][] data = { { "조하영", "920419", "서울시중랑구" }, { "유수영", "900327", "서울시종로구" }, { "온지인", "900829", "서울시중구" },
			{ "이수연", "900515", "서울시마포구" }, };

	public AddressBook() {
		setBounds(100, 100, 900, 200);
		setTitle("연락처");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 테이블 모델만들기
		DefaultTableModel model = new DefaultTableModel(data, columns);

		// 테이블 모델을 이용해서 테이블 만들기 방법1)
		JTable table = new JTable(model);
		// table.setModel(model); // 데이터 나중에 만들때, 테이블 만들기 방법2)

		// 출력영역의 크기보다 table이 커지더라도 스크롤바를 이용할 수 있도록 Scroll생성
		JScrollPane scrollPane = new JScrollPane(table);
		// 스크롤패인을 프레임에 부착
		add(scrollPane);
		
				
		JLabel lblName = new JLabel("이름");
		JTextField tfName = new JTextField(10);
		JLabel lblBirth = new JLabel("생년월일");
		JTextField tfBirth = new JTextField(15);
		JLabel lblAddress = new JLabel("주소");
		JTextField tfAddress = new JTextField(30);
	
		JButton btnInsert = new JButton("삽입");
		JButton btnDelete = new JButton("삭제");
				
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
		
		
		//삽입버튼의 클릭이벤트 - ActionListener처리
		ActionListener insertListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트 필드에 입력된 내용가져오기
				String name = tfName.getText();
				String birth = tfBirth.getText();
				String address = tfAddress.getText();
				
				//유효성검사-좌우공백제거
				name = name.trim();
				birth = birth.trim();
				address = address.trim();
				//유효성검사-name필수입력
				//이름이 입력되지 않은 경우 (length)길이가 0 - null이 아니야!
				if(name.length()==0) {
					JOptionPane.showMessageDialog(null, "이름은 필수입력", "이름", JOptionPane.WARNING_MESSAGE);
				//아래쪽을 더이상 수행하지 않도록 리턴
				return;
				}
										
				//테이블의 데이터를 편집하기 위해 테이블의 데이터 모델을 가져온다.
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				//데이터를 추가하기 위해 추가할 데이터 배열을 생성
				String[] row = {name,birth,address};
				//모델에 추가
				model.addRow(row);
				//테이블 갱신
				table.updateUI();		
				
				//텍스트 필드 클리어
				tfName.setText("");
				tfBirth.setText("");
				tfAddress.setText("");
				//메시지 박스출력
				JOptionPane.showMessageDialog(null, "데이터입력성공", "입력작업", JOptionPane.PLAIN_MESSAGE);
			}			
		};
		btnInsert.addActionListener(insertListener);
		
		
		
		//삭제버튼의 클릭이벤트 - ActionListener처리
		ActionListener deleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//선택한 행번호 찾기
				int idx = table.getSelectedRow(); 
				//테이블에서 행을 선택하지 않앗다면 
				if(idx<0||idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "행을선택하세요", "삭제실패", JOptionPane.WARNING_MESSAGE);
					//아래쪽을 더이상 수행하지 않도록 리턴
					return;
				}
				
				//테이블의 모델가져오기
				DefaultTableModel model =(DefaultTableModel)table.getModel(); 
				//선택된 행에 해당하는 데이터지우기
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null, "데이터삭제", "삭제", JOptionPane.WARNING_MESSAGE);
			}			
		};
		btnDelete.addActionListener(deleteListener);
			
		
		
		
		// 메뉴바 생성
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("파일(a)"); //단축키설정
		file.setMnemonic('a');

		JMenuItem item1 = new JMenuItem("열기");
		file.add(item1);
		JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("저장");
		file.add(item2);
		JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("편집");
		file.add(item3);

		menuBar.add(file);

		setJMenuBar(menuBar);  // 메뉴바를 윈도우에 부착

			
		
		// JOptionPane
		// MessageDialog 메시지 다이얼로그 출력
		//JOptionPane.showMessageDialog(null,"메시지다이얼로그","대화상자",JOptionPane.QUESTION_MESSAGE);

		// ConfirmDialog 선택다이얼로그출력
		//int r = JOptionPane.showConfirmDialog(null, "메시지다이얼로그", "대화상자", JOptionPane.YES_NO_OPTION);
		//System.out.println(r);

		// InputDialog 한줄입력받는 다이얼로그 출력
		// String r = JOptionPane.showInputDialog(null,"메시지다이얼로그","대화상자",JOptionPane.YES_NO_OPTION);
		// System.out.println(r);

	}
}
