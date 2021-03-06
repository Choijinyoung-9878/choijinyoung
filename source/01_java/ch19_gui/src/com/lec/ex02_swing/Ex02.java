package com.lec.ex02_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex02 extends JFrame implements ActionListener {
	// 필요한 컴포넌트 변수 추가
//	private JPanel jpanel; // 컨테이너 얻어올 변수
	private Container contenPane; // 컨테이너 얻어올 변수
	private ImageIcon icon; // 버튼에 들어갈 icon 변수
	private JButton jBtn;
	private JTextField jtxtField;
	private Vector<String> items; // 컴보박스에 들어갈 item 리스트 Vector로 하는이유 : item이 가변적일때는 Vector, 고정적일때는 String배열
	private String[] item = { "A", "B", "C" };
	private JComboBox<String> jCombo;
	private JCheckBox jCheck;
	private JLabel jlBlank; // 빈 라벨
	private JButton jBtnExit; // 종료버튼

	// 생성자 : 컨테이너 얻어와서 layout 세팅 -> 컴포넌트 생성 후 add -> setVisible, setSize (화면구현) ->
	// 이벤트 추가
	public Ex02() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // swing은 컨테이너를 얻어온 후 작업
//		jpanel = (JPanel)getContentPane();  // 위에줄은 컨테이너를 바로  컨테이너에    / 이거는 jpanel에 컨테이너를 받아오는거
		contenPane.setLayout(new FlowLayout()); // 레이아웃 지정
		icon = new ImageIcon("icon/icon/write.gif"); // 아이콘 개체
		jBtn = new JButton("Button", icon);
		jtxtField = new JTextField(20); // 20글자 확보된 textfield
//		jCombo = new JComboBox<String>(item); // 컴보박스 item 리스트 추가 방법 1. string 배열(고정) 
		items = new Vector<String>();
		// items 추가할 사랑들 가져오기
		items.add("A");
		items.add("B");
		items.add("C");
		jCombo = new JComboBox<String>(items); // 컴보박스 item 리스트 추가방법 2. vector 이용(가변적)
		jCheck = new JCheckBox("CheckBox");
		jlBlank = new JLabel("");
		jBtnExit = new JButton("Exit");

		// 컨포넌트 add -> 컨포넌트 사이즈 조정
		contenPane.add(new JLabel("Label"));
		contenPane.add(jBtn);
		contenPane.add(jtxtField);
		contenPane.add(jCombo);
		contenPane.add(jCheck);
		contenPane.add(jlBlank);
		contenPane.add(jBtnExit);
		jBtn.setPreferredSize(new Dimension(200, 50));
		jtxtField.setPreferredSize(new Dimension(300, 50));
		jCombo.setPreferredSize(new Dimension(100, 50));
		jCheck.setPreferredSize(new Dimension(100, 50));
		jlBlank.setPreferredSize(new Dimension(200, 50));
		jBtnExit.setPreferredSize(new Dimension(100, 50));
		setVisible(true);
		pack(); // 컴포넌트들을 포함한 최소한의 사이즈로 고정
		setLocation(100, 50);
		// 이벤트 리스너 추가
		jBtn.addActionListener(this);
		jCombo.addActionListener(this);
		jCheck.addActionListener(this);
		jBtnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if (e.getSource() == jBtn) {
			String temp = jtxtField.getText().trim().toUpperCase();
			if (temp.equals("")) {
				System.out.println("떼끼"); // jtxtField에 빈스트링 이거나 스페이스만 입력했을 경우
				return;
			}
			jCombo.addItem(temp); // 내가 친 스트링들이 콤보박스에 추가됨 // 콤보박스에 item 추가 (=items 벡터에 추가)
			jlBlank.setText(jtxtField.getText().trim()); // jlBlank에는 jtxtField 입력 내용 그대로
			jtxtField.setText("");
		} else if (e.getSource() == jCombo) {
			String temp = jCombo.getSelectedItem().toString(); // 콤보박스 선택된 항목("A","B",...)
			int no = jCombo.getSelectedIndex(); // 선택한게 몇번째인지 불러옴
			jlBlank.setText((no + 1) + " 번째 " + temp + " 선택 ");
			jCombo.setSelectedItem("A"); // "A" 가 선택되도록  콤보박스 선택  초기화 느낌 a로 초기화 느낌
//			jCombo.setSelectedIndex(0);   위에랑 똑같음 0번째 인덱스를 선택되도록			
		} else if (e.getSource() == jCheck) {
			if (jCheck.isSelected()) { // 체크박스 체크함
				jlBlank.setText(jCheck.getText());
			} else { // 체크박스 언체크함
				jlBlank.setText("");
			}
		} else if (e.getSource() == jBtnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Ex02();
	}

}
