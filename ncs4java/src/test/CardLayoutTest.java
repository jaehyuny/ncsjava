package test;

import java.io.*;
import java.awt.*;

 
class CardLayoutTest extends Frame {

   CardLayout cl = null;
 

   public CardLayoutTest() {

      cl = new CardLayout();
      setLayout(cl); //ī�� ���̾ƿ��� ����ϵ��� ����

 
      Panel p1 = new Panel();

      p1.setLayout(new BorderLayout());
	  p1.add("North", new Label("Card 1. BorderLayout - North", Label.CENTER));
      p1.add("East", new Button("East"));
      p1.add("West", new Button("West"));
      p1.add("Center", new Button("Center"));
      p1.add("South", new Button("South"));


      Panel p2 = new Panel();

      p2.add(new Label("Card 2. DefaultLayout", Label.CENTER));
      p2.add(new Button("Button 1"));
      p2.add(new Button("Button 2"));
      p2.add(new Button("Button 3"));


      Panel p3 = new Panel();

      p3.setLayout(new GridLayout(2, 2));
      p3.add(new Label("Card 3. GridLayout", Label.CENTER));
      p3.add(new Button("Button p3-1"));
      p3.add(new Button("Button p3-2"));
      p3.add(new Button("Button p3-3"));


      add(p1, "BorderLayout");
      //add(p1, "BorderLayout2");
      add(p2, "DefaultLayout");
      //add(p2, "DefaultLayout2");
      add(p3, "GridLayout");
      //add(p3, "GridLayout2");
      add(new Button("Card 4. Button"), "Button");
      //add(new Button("Button"), "Button2");


      Choice colorChooser = new Choice();
      colorChooser.add("Card 5. Choice");
      colorChooser.add("Red");
      colorChooser.add("Blue");
      add(colorChooser, "Colors");
      //add(colorChooser, "Colors2");

   }

 

   public static void main(String args[]) {

      CardLayoutTest frm = new CardLayoutTest();

      int ch;

      frm.pack();
      frm.setTitle("CardLayout");
      frm.setVisible(true);

 
      try {

         while((ch=System.in.read()) != -1) { //�ܼ� â�� ���� Ű �Է��� �޴´�.

            if(frm.cl != null) {

               frm.cl.next(frm); //Ű �Է�(����)�� ������ ���� ī�带 �����ش�.
               //void next(Container parent): �־��� �����̳ʿ� ���Ե� ���� ī�带 �����ݴϴ�.
               //void first(Container parent): �־��� �����̳ʿ� ���Ե� ù ��° ī�带 �����ݴϴ�.
               //void last(Container parent): �־��� �����̳ʿ� ���Ե� ������ ��° ī�带 �����ݴϴ�.
               //void previous(Container parent): �־��� �����̳ʿ� ���Ե� ���� ī�带 �����ݴϴ�.
               //void show(Container parent, String name): �־��� �����̳ʿ� ���Ե� ������Ʈ �� �־��� �̸��� ���� ������Ʈ�� ��ȯ�մϴ�(�����ݴϴ�).

            }

         }

      } catch(IOException e) {
    	  System.out.println(e);
      }

   }

}
