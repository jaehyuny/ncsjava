package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectMode extends JPanel{
	JButton single = new JButton("Single Play");
	JButton multi = new JButton("Multi Play");
	
	public SelectMode() {
//		JFrame frame = new JFrame("Baseball Manager");
//		frame.setPreferredSize(new Dimension(600, 500));
//		frame.setLocation(400, 200);
//		Container contentPane = frame.getContentPane();
		GridLayout grid = new GridLayout(1,2);
		setLayout(grid);
		JPanel panel1 = new JPanel();
		Font f1 = new Font("µ¸¿ò",Font.BOLD, 40);
		single.setFont(f1);
		multi.setFont(f1);
		panel1.setLayout(grid);
		panel1.add(single);
		panel1.add(multi);
		add(panel1);
//		contentPane.add(panel1, BorderLayout.CENTER);
//		MouseListener play = new SelectPlayMode(single, multi);
//		single.addMouseListener(play);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.pack();
//		frame.setVisible(true);
	}
	 @Override
	 protected void paintComponent(Graphics g) {
		 
	 }
}
