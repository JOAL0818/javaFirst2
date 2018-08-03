package oracleuse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class ContactView extends JFrame {
	// 필요한 UI변수선언

	// 레이블선언
	JLabel lblName, lblPhone, lblEmail, lblBirthday;
	// 입력받을 텍스트필드 선언
	JTextField tfName, tfPhone, tfEmail, tfBirthday;
	// 버튼변수
	JButton btnFirst, btnLast, btnPrev, btnNext;
	JButton btnInsert, btnUpdate, btnDelete, btnSearch, btnClear;
	// 현재 출력중인 데이터의 인덱스를 표시할 레이블
	JLabel IblIndex;

	// 데이터베이스 작업을 위한 Dao변수
	ContactDao dao = new ContactDaoImpl();
	// 데이터베이스에서 가져온 결과를 저장하기 위한 List
	List<Contact> list;
	// 현재출력중인 데이터의 인덱스를 저장할 변수
	int idx;

	// idx번째 데이터를 화면에 출력해주는 메소드
	// 맨 처음 한번 호출하고 데이터베이스에 작업이 발생하면 호출하는 메소드
	private void printData() {
		// 읽을 데이터가 없다면 메시지 박스를 출력하고 return
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "읽을데이터가 없습니다.", "데이터없음", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// List에서 idx번째 데이터를 가져옵니다.
		Contact contact = list.get(idx);
		tfName.setText(contact.getName());
		tfPhone.setText(contact.getPhone());
		tfEmail.setText(contact.getEmail());
		// 생일은 Date타입이므로 String으로 변환해서 출력
		tfBirthday.setText(contact.getBirthday().toString());
		IblIndex.setText(String.format("%d", idx + 1));
		IblIndex.setText((idx + 1) + ""); // 숫자는 1부터 시작하니까, 1더해서 출력
	}

	// 생성자 : 객체를 만들때 초기화를 위해서 생성
	// *실제 코드가 너무 길어지면 쪼개라 - 안그러면 코드읽기가 너무 힘들다
	// 너무 많으면 스택이 터져서 에러가 나기도한다. : stack overflow
	// 메소드당 20-30줄 / 클래스는 최대 200줄
	public ContactView() {
		// 중앙에 배치할 패널생성
		JPanel centerPanel = new JPanel();
		// 레이블생성
		lblName = new JLabel("이름", JLabel.RIGHT);
		lblPhone = new JLabel("전화번호", JLabel.RIGHT);
		lblEmail = new JLabel("이메일", JLabel.RIGHT);
		lblBirthday = new JLabel("생년월일", JLabel.RIGHT);
		// 텍스트필드생성
		tfName = new JTextField();
		tfPhone = new JTextField();
		tfEmail = new JTextField();
		tfBirthday = new JTextField();

		// 4행2열 배치될 수 있는 레이아웃으로 변경
		centerPanel.setLayout(new GridLayout(4, 2, 3, 3));

		centerPanel.add(lblName);
		centerPanel.add(tfName);
		centerPanel.add(lblPhone);
		centerPanel.add(tfPhone);
		centerPanel.add(lblEmail);
		centerPanel.add(tfEmail);
		centerPanel.add(lblBirthday);
		centerPanel.add(tfBirthday);

		add("Center", centerPanel);

		display(); // 메소드 라인이 너무길어 쪼개서 저장

		setBounds(200, 200, 600, 380);
		setTitle("연락처");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		// 데이터베이스에서 데이터를 가져옵니다.
		// *setVisible 앞에 오느냐 뒤에 오느냐에 따라 화면에 출력되는 순서가 다르다
		list = dao.allContact();
		printData();
	}

	// 위의 메소드가 너무 길어서 쪼개주었다
	private void display() {
		// 버튼생성
		btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idx == 0) {
					JOptionPane.showMessageDialog(null, "첫번째데이터입니다.", "조회에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				idx = 0;
				printData();
			}
		});

		btnPrev = new JButton("Preview");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idx == 0) {
					JOptionPane.showMessageDialog(null, "첫번째데이터입니다.", "조회에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				idx = idx - 1;
				printData();
			}
		});

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 방1)맨마지막일때 맨처음으로 다시 돌아가는 것
				idx = idx + 1;
				if (idx == list.size()) {
					idx = 0;
				}

				// 방2)맨마지막일때 에러메시지 뜨는 방법
//				if(idx==list.size()-1) {
//					JOptionPane.showMessageDialog(null, "마지막데이터입니다.", "조회에러", JOptionPane.ERROR_MESSAGE);
//					return;
//				}				
//				idx = idx+1;

				printData();
			}
		});

		btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idx == list.size() - 1) {
					JOptionPane.showMessageDialog(null, "마지막데이터입니다.", "조회에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				idx = list.size() - 1;
				printData();
			}
		});

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//IblIndex의 텍스트가 삽입이 아니면 메시지 박스를 출력하고 함수의 수행종료
				//문자열의 동일성 여부는 ==가 아니고 equals로 해야한다.
				if(IblIndex.getText().equals("삽입")==false) {
					JOptionPane.showMessageDialog(null, "지우고 쓰세요", "삽입에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//입력한 데이터 가져오기
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String email = tfEmail.getText();
				String birthday = tfBirthday.getText();
				
				//name은 필수입력이고 3자이상 입력했는지 검사
				if(name.trim().length()<3) {
					JOptionPane.showMessageDialog(null, "이름은 3자이상", "이름오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//phone은 전부 숫자이고 11자리인지 검사
				if(phone.trim().length()<11) {
					JOptionPane.showMessageDialog(null, "전화번호는 11자리", "전화번호오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int i=0;
				while(i<phone.trim().length()) {
					char ch = phone.trim().charAt(i);
					if(ch<'0'||ch>'9') {
						JOptionPane.showMessageDialog(null, "전화번호는 숫자만", "전화번호는 오류", JOptionPane.ERROR_MESSAGE);
						return;
					}
					i=i+1;
				}
				
				//Dao의 메소드에 맞게 데이터를 생성
				Contact contact = new Contact();
				contact.setNum(list.get(idx).getNum());
				contact.setName(name);
				contact.setEmail(email);
				contact.setPhone(phone);
				
				//yyyy-mm-dd형식의 문자열을 가지고 Date만들기
				//0번째부터 4번째 앞까지
				int year = Integer.parseInt(birthday.substring(0, 4));
				int month = Integer.parseInt(birthday.substring(5,7));
				int day = Integer.parseInt(birthday.substring(8));
				//Calendar 객체를 만들어서 입력한 데이터를 가지고 Calendar를 수정
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month-1);
				cal.set(Calendar.DAY_OF_MONTH, day);
				//Calendar객체를 이용해서 Date 객체만들기
				Date date = new Date(cal.getTimeInMillis());
				contact.setBirthday(date);	
				//위 문장들 대신에 가능
				//contact.setBirthday(Date.valueOf(birthday));
				
				//DB작업수행
				dao.insertContact(contact);
				//작업수행 후 재출력을 위해 데이터를 가져오고 인덱스조정
				list = dao.allContact();
				idx=list.size()-1;
				//대화상자출력
				printData();
				JOptionPane.showMessageDialog(null, "삽입성공", "데이터삽입", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력한텍스트 전부가져오기
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String email = tfEmail.getText();
				String birthday = tfBirthday.getText();
								
				String message="";
				//name의 데이터가 비어있으면 메시지 박스출력하고 리턴하기				
				if(name.trim().length()<1) {
					message="이름은 필수입력입니다.";
				}
				//전화번호가 비어있으면 메시지 박스출력
				else if(phone.trim().length()<1) {
					message="전화번호는 필수입력입니다.";
				}else if(email.trim().length()<1) {
					message="이메일은 필수입력입니다.";					
				}if(message.length()>=1) {
					JOptionPane.showMessageDialog(null, message, "입력오류", JOptionPane.ERROR_MESSAGE);
					return;					
				}
				//날짜 데이터가 년도 4자리 - 월2자리 - 일2자리 형식인지 조사
				int i=0;
				if(birthday.length()!=10) {
					JOptionPane.showMessageDialog(null, "생일은 10자리로 만들어주세요", "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}				
				while(i<birthday.length()) {
					char ch = birthday.charAt(i);
					//첫번째부터 네번째까지 숫자가 아니면 반복문 종료
					if(i>=0&&i<=3) {
						if(ch<'0'||ch>'9') {
							break;
						}
					}
					if(i==4||i==7) {
						if(ch != '-') {
							break;
						}
					}
					if(i==5) {
						if(ch !='0' &&ch!='1') {
							break;
						}
					}
					if(i==6) {
						if(ch<'0'||ch>'9' ) {
							break;
						}
					}
					if(i>7) {
						if(ch<'0'||ch>'9') {
							break;
						}
					}
					i=i+1;  // 주의! 이친구가 빠지면 무한반복문이된다.
				}
				if(i!=birthday.length()) {
					JOptionPane.showMessageDialog(null, "생일은 YYYY-MM-DD 형식", "입력오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Contact contact = new Contact();
				contact.setNum(list.get(idx).getNum());
				contact.setName(name);
				contact.setEmail(email);
				contact.setPhone(phone);
				
				//yyyy-mm-dd형식의 문자열을 가지고 Date만들기
				//0번째부터 4번째 앞까지
				int year = Integer.parseInt(birthday.substring(0, 4));
				int month = Integer.parseInt(birthday.substring(5,7));
				int day = Integer.parseInt(birthday.substring(8));
				//Calendar 객체를 만들어서 입력한 데이터를 가지고 Calendar를 수정
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month-1);
				cal.set(Calendar.DAY_OF_MONTH, day);
				//Calendar객체를 이용해서 Date 객체만들기
				Date date = new Date(cal.getTimeInMillis());
				contact.setBirthday(date);	
				//위 문장들 대신에 가능
				//contact.setBirthday(Date.valueOf(birthday));
				
				dao.updateContact(contact);
				JOptionPane.showMessageDialog(null, "수정성공", "데이터수정", JOptionPane.INFORMATION_MESSAGE);
				list = dao.allContact();
				printData();
			}
		});
		
		btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "정말로삭제?", "삭제", JOptionPane.YES_NO_OPTION);
				System.out.println(r);
				if(r==0) {
					JOptionPane.showMessageDialog(null, "삭제성공", "삭제", JOptionPane.INFORMATION_MESSAGE);
				//번호를 이용해서 삭제
				dao.deleteContact(list.get(idx).getNum());
				list = dao.allContact();
				idx=0;
				printData();				
				}
			}
		});

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "조회할 이름의 일부분을 입력하세요", JOptionPane.QUESTION_MESSAGE);
				tfName.setText("");
				tfPhone.setText("");
				tfEmail.setText("");
				tfBirthday.setText("");
				if (name != null) {
					list = dao.nameContact(name.trim().toUpperCase());
					idx = 0;
					printData();
				}
			}
		});

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트필드들의 텍스트를 전부삭제
				tfName.setText("");
				tfEmail.setText("");
				tfPhone.setText("");
				tfBirthday.setText("");
				//IblIndex의 타이틀을 삽입으로 변경
				IblIndex.setText("삽입");				
			}			
		});
		
		IblIndex = new JLabel("", JLabel.CENTER);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 5, 7, 7));
		panel1.setBorder(new TitledBorder("조회"));
		panel1.add(btnFirst);
		panel1.add(btnPrev);
		panel1.add(IblIndex);
		panel1.add(btnNext);
		panel1.add(btnLast);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 5, 7, 7));
		panel2.setBorder(new TitledBorder("작업"));
		panel2.add(btnInsert);
		panel2.add(btnUpdate);
		panel2.add(btnDelete);
		panel2.add(btnSearch);
		panel2.add(btnClear);

		JPanel p = new JPanel(new BorderLayout());
		p.add("Center", panel1);
		p.add("South", panel2);
		add("South", p);
	}
}