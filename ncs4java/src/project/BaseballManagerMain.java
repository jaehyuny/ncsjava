package project;

import java.awt.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class BaseballManagerMain extends JFrame implements ActionListener{
	CardLayout card = new CardLayout();
	SelectMode select = new SelectMode();
	MainMenu mm = new MainMenu();
	BaseballManagerPlay bmp = new BaseballManagerPlay();
	
	public BaseballManagerMain() {
		setTitle("BaseballManager");
		setLocation(400, 200);
		getContentPane();
		setLayout(card);
		add("select", select);
		add("mm", mm);
		add("bmp", bmp);
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		select.single.addActionListener(this);
		mm.play.addActionListener(this);
	}
	public static void main(String[] args) {
		new BaseballManagerMain();
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==select.single) {
	    card.show(getContentPane(), "mm");
	   }
	   if(e.getSource()==mm.play) {
		   card.show(getContentPane(), "bmp");
	   }
	 }

}
