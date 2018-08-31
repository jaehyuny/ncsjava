package member;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import guipackage.ComboSelectedChange;
import guipackage.FileReadAndWrite;
import guipackage.MouseListenerClick;

public class MemberGuiMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("File Read");
		frame.setPreferredSize(new Dimension(600, 300));
		frame.setLocation(500, 200);
		Font font20 = new Font("굴림", Font.TYPE1_FONT, 12);
		Container contentPane = frame.getContentPane();
		String colNames[] = {"email", "name", "gender"};
		Object data[][] = { {"김철수", 24, '남'},
							{"이순희", 21, '여'},
							{"박지영", 26, '여'} };
		DefaultTableModel model = new DefaultTableModel(data,colNames);
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.CYAN);
		header.setFont(new Font("굴림",Font.TYPE1_FONT, 15));
		table.setFont(font20);
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();
		JLabel nametxt = new JLabel("이름");
		JTextField name = new JTextField(6);
		JLabel agetxt = new JLabel("나이");
		JTextField age = new JTextField(5);
		JLabel gendertxt = new JLabel("성별");
		JTextField gender = new JTextField(3);
		JTextField delrow = new JTextField(10);
		JButton btn = new JButton("입력");
		JButton del = new JButton("호출");
		btn.setForeground(Color.GREEN);
		panel.add(nametxt);
		panel.add(name);
		panel.add(agetxt);
		panel.add(age);
		panel.add(gendertxt);
		panel.add(gender);
		panel.add(btn);
		panel.add(delrow);
		panel.add(del);
		ActionListener btnlistener = new MemberInsertClick(model, name, age, gender, delrow);
		btn.addActionListener(btnlistener);
		del.addActionListener(btnlistener);
		MouseListener mouse = new MouseClick(model, table, delrow);
		table.addMouseListener(mouse);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
