package test;

import java.io.*;
import java.awt.*;

 
class CardLayoutTest extends Frame {

   CardLayout cl = null;
 

   public CardLayoutTest() {

      cl = new CardLayout();
      setLayout(cl); //카드 레이아웃을 사용하도록 설정

 
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

         while((ch=System.in.read()) != -1) { //콘솔 창을 통해 키 입력을 받는다.

            if(frm.cl != null) {

               frm.cl.next(frm); //키 입력(엔터)이 있으면 다음 카드를 보여준다.
               //void next(Container parent): 주어진 컨테이너에 포함된 다음 카드를 보여줍니다.
               //void first(Container parent): 주어진 컨테이너에 포함된 첫 번째 카드를 보여줍니다.
               //void last(Container parent): 주어진 컨테이너에 포함된 마지막 번째 카드를 보여줍니다.
               //void previous(Container parent): 주어진 컨테이너에 포함된 이전 카드를 보여줍니다.
               //void show(Container parent, String name): 주어진 컨테이너에 포함된 컴포넌트 중 주어진 이름을 가진 컴포넌트로 전환합니다(보여줍니다).

            }

         }

      } catch(IOException e) {
    	  System.out.println(e);
      }

   }

}
