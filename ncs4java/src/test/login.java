package test;

import java.awt.*;

import javax.swing.*;


public class login extends JPanel{
	 
	 JLabel la1,la2;
	 JTextField tf;
	 JPasswordField pf;
	 JButton b1,b2;
	 Image img;
	 
	 public login()
	 {
	   img=Toolkit.getDefaultToolkit().getImage("c:\\ing\\back.jpg");
	   la1=new JLabel("ID");
	   la2=new JLabel("PW");
	   tf=new JTextField();
	   pf=new JPasswordField();
	   b1=new JButton("Login");
	   b2=new JButton("Cancel");
	   //��ġ
	   setLayout(null); //null���� �ְ� �Ǹ� Programmer�� ������ġ��.
	     la1.setBounds(10,15,50,20);
	     tf.setBounds(65, 15, 120, 20);
	     
	     la2.setBounds(10,40,50,20);
	     pf.setBounds(65, 40, 120,20);
	   
	   JPanel p=new JPanel();
	   
	   p.setOpaque(false); //������ ��ȯ
	   /*
	    *  JRadioButoon,JPanel : ��������
	    */
	   p.add(b1);
	   p.add(b2);
	   
	   p.setBounds(10, 65, 175, 35);
	   
	   //�߰�
	   add(la1);add(tf);
	   add(la2);add(pf);
	   add(p);
	   
	   
	   
	 }

	 @Override
	 protected void paintComponent(Graphics g) {
	  g.drawImage(img,  0,0,getWidth(),getHeight(),this);
	 }

	 

	}


