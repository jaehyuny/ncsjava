package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JMenuItem;

public class MainClass extends JFrame implements ActionListener
{
 CardLayout card=new CardLayout();
 login Login = new login();
 MenuForm mf=new MenuForm();
 JMenuItem startItem,stopItem,exitItem;
 
 public MainClass()
 {
  JMenuBar bar=new JMenuBar();
  JMenu menu=new JMenu("����");
  
  startItem=new JMenuItem("����");
  stopItem=new JMenuItem("����");
  exitItem=new JMenuItem("����");
  
  menu.add(startItem);
  menu.add(stopItem);
  menu.addSeparator(); //��ɺ��� �����ִ� ���μ�
  menu.add(exitItem);
  
  bar.add(menu);
  
  setJMenuBar(bar);
  
  setLayout(card);
  add("LOGIN",Login);
  add("MF",mf);
  setSize(640,480); //window ũ�� ����
  setVisible(true); //window�� �����ش�. 
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  //x��ư Ŭ���� �޸� ����
  //window ==> dispose();System.exit(0);
  Login.b1.addActionListener(this);
  //�̺�Ʈ ���
 }
 public static void main(String[] args) {
  
  new MainClass();
 }
 @Override
 public void actionPerformed(ActionEvent e) {
   if(e.getSource()==Login.b1)
   {
    card.show(getContentPane(), "MF");
    //JRootPane���� : ������(����â)
   }
 }

}


