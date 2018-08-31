package project;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;

public class MainMenu extends JPanel{
	JButton play = new JButton("PLAY BALL");
	JButton ranking = new JButton("�� ����");
	JButton playerstat = new JButton("���� ���");
	JButton teamstat = new JButton("�� ���");
	
	public MainMenu() {
		setLayout(new BorderLayout());
		GridLayout grid = new GridLayout(4,1);
		JPanel panel1 = new JPanel();
		Font f1 = new Font("����",Font.BOLD, 40);
		play.setFont(f1);
		ranking.setFont(f1);
		playerstat.setFont(f1);
		teamstat.setFont(f1);
		panel1.setLayout(grid);
		panel1.add(play);
		panel1.add(ranking);
		panel1.add(playerstat);
		panel1.add(teamstat);
		add("Center", panel1);
	}
}
