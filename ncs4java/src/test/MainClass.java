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
  JMenu menu=new JMenu("게임");
  
  startItem=new JMenuItem("시작");
  stopItem=new JMenuItem("정지");
  exitItem=new JMenuItem("종료");
  
  menu.add(startItem);
  menu.add(stopItem);
  menu.addSeparator(); //기능별로 나눠주는 라인선
  menu.add(exitItem);
  
  bar.add(menu);
  
  setJMenuBar(bar);
  
  setLayout(card);
  add("LOGIN",Login);
  add("MF",mf);
  setSize(640,480); //window 크기 결정
  setVisible(true); //window를 보여준다. 
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  //x버튼 클릭시 메모리 해제
  //window ==> dispose();System.exit(0);
  Login.b1.addActionListener(this);
  //이벤트 등록
 }
 public static void main(String[] args) {
  
  new MainClass();
 }
 @Override
 public void actionPerformed(ActionEvent e) {
   if(e.getSource()==Login.b1)
   {
    card.show(getContentPane(), "MF");
    //JRootPane연결 : 관리자(투명창)
   }
 }

}


