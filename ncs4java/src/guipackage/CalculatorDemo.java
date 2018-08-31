package guipackage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

import javax.swing.*;

public class CalculatorDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("µ¡¼À ÇÁ·Î±×·¥");
		frame.setPreferredSize(new Dimension(400,150));
		frame.setLocation(500, 200);
		Container containpanel = frame.getContentPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JTextField tf1 = new JTextField(6);
		JTextField tf2 = new JTextField(6);
		JLabel res = new JLabel();
		JButton but1 = new JButton("+");
		JButton but2 = new JButton("-");
		JButton but3 = new JButton("*");
		JButton but4 = new JButton("/");
		JButton but5 = new JButton("cle");
		JLabel lab1 = new JLabel(" ");
		JLabel lab2 = new JLabel("=");
		panel1.add(tf1);
		panel1.add(lab1);
		panel1.add(tf2);
		panel1.add(lab2);
		panel1.add(res);
		panel2.add(but1);
		panel2.add(but2);
		panel2.add(but3);
		panel2.add(but4);
		panel2.add(but5);
		containpanel.add(panel1, BorderLayout.CENTER);
		containpanel.add(panel2, BorderLayout.SOUTH);
		ActionListener listener = new ClickEvent(tf1, lab1, tf2, res);
		but1.addActionListener(listener);
		but2.addActionListener(listener);
		but3.addActionListener(listener);
		but4.addActionListener(listener);
		but5.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
