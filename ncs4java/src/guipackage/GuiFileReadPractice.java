package guipackage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GuiFileReadPractice {
	public static void main(String[] args) {
		JFrame frame = new JFrame("File Read");
		frame.setPreferredSize(new Dimension(400, 300));
		frame.setLocation(500, 200);
		Container contentPane = frame.getContentPane();
		JTextArea area1 = new JTextArea(6,10);
//		JTextArea area2 = new JTextArea(6,10);
		JComboBox area2 = new JComboBox();
		JScrollPane scrollpane1 = new JScrollPane(area1);
//		JScrollPane scrollpane2 = new JScrollPane(area2);
		JPanel panel = new JPanel();
		JTextField tf1 = new JTextField(6);
		JTextField tf2 = new JTextField(6);
		JButton but1 = new JButton("파일검색");
		JButton but2 = new JButton("파일출력");
		tf1.setText("d:\\");
		panel.add(tf1);
		panel.add(but1);
		panel.add(tf2);
		panel.add(but2);
		contentPane.add(scrollpane1,BorderLayout.CENTER);
//		contentPane.add(scrollpane2,BorderLayout.NORTH);
		contentPane.add(area2,BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.SOUTH);
		ActionListener listener = new FileReadAndWrite(tf1, tf2, area1, area2);
		MouseListener mouse = new MouseListenerClick(area2, tf2);
		area2.addMouseListener(mouse);
		ItemListener change = new ComboSelectedChange(area2, tf2);
		area2.addItemListener(change);
		but1.addActionListener(listener);
		but2.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
