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
  la=new JLabel("�޴�",JLabel.CENTER);
  rb1=new JRadioButton("�������");
  rb2=new JRadioButton("�߱�����");
  rb3=new JRadioButton("��ٸ�����");
  rb4=new JRadioButton("��������");
  
  rb1.setOpaque(false);
  rb2.setOpaque(false);
  rb3.setOpaque(false);
  rb4.setOpaque(false);
  
  la.setFont(new Font("�������",Font.BOLD,20));
  //������ư�� ������ �׷�ȭ
  ButtonGroup bg=new ButtonGroup();
  bg.add(rb1);
  bg.add(rb2);
  bg.add(rb3);
  bg.add(rb4);
  
  //����Ʈ üũ
  rb1.setSelected(true);
  
  rb1.setFont(new Font("�������",Font.BOLD,20));
  rb2.setFont(new Font("�������",Font.BOLD,20));
  rb3.setFont(new Font("�������",Font.BOLD,20));
  rb4.setFont(new Font("�������",Font.BOLD,20));
  //��ġ
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


