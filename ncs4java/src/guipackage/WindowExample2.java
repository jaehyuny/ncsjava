package guipackage;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Program");
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setLocation(500, 200);
		Container contentPane = frame.getContentPane();
		JTextField text = new JTextField();
		JButton button = new JButton("»Æ¿Œ");
		JButton button1 = new JButton("Success");
		JLabel label = new JLabel("Hello");
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(button1, BorderLayout.NORTH);
		contentPane.add(label, BorderLayout.SOUTH);
		ActionListener listener = new MyClickEventClass(text, label);
		button.addActionListener(listener);
		button1.addActionListener(listener);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
