package test;

import java.awt.*;

import javax.swing.*;

public class MenuForm extends JPanel
{
 JLabel la;
 JRadioButton rb1;
 JRadioButton rb2;
 JRadioButton rb3;
 JRadioButton rb4;
 
 public MenuForm()
 {
  setBackground(new Color(248,196,253));
  la=new JLabel("메뉴",JLabel.CENTER);
  rb1=new JRadioButton("퍼즐게임");
  rb2=new JRadioButton("야구게임");
  rb3=new JRadioButton("사다리게임");
  rb4=new JRadioButton("게임종료");
  
  rb1.setOpaque(false);
  rb2.setOpaque(false);
  rb3.setOpaque(false);
  rb4.setOpaque(false);
  
  la.setFont(new Font("맑은고딕",Font.BOLD,20));
  //라디오버튼은 무조건 그룹화
  ButtonGroup bg=new ButtonGroup();
  bg.add(rb1);
  bg.add(rb2);
  bg.add(rb3);
  bg.add(rb4);
  
  //디폴트 체크
  rb1.setSelected(true);
  
  rb1.setFont(new Font("맑은고딕",Font.BOLD,20));
  rb2.setFont(new Font("맑은고딕",Font.BOLD,20));
  rb3.setFont(new Font("맑은고딕",Font.BOLD,20));
  rb4.setFont(new Font("맑은고딕",Font.BOLD,20));
  //배치
  setLayout(null);
  la.setBounds(10, 15, 620, 40);
  rb1.setBounds(280, 75, 120, 30);
  rb2.setBounds(280, 115, 120, 30);
  rb3.setBounds(280, 155, 130, 30);
  rb4.setBounds(280, 195, 120, 30);
  
  add(la);
  add(rb1);
  add(rb2);
  add(rb3);
  add(rb4);
 
  
 }
 
}


