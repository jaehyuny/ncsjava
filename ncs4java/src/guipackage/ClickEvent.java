package guipackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClickEvent implements ActionListener {
	JTextField tf1;
	JTextField tf2;
	JLabel res;
	JLabel lab1;
	ClickEvent(JTextField tf1, JLabel lab1, JTextField tf2, JLabel res){
		this.tf1 = tf1;
		this.tf2 = tf2;
		this.res = res;
		this.lab1 = lab1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String o= e.getActionCommand();
		if(o.equals("cle")) {
			tf1.setText("");
			lab1.setText("");
			tf2.setText("");
			res.setText("");
			return;
		}
		boolean result = checkDigit(tf1.getText());
		if(!result) {
			JOptionPane.showMessageDialog(null, "첫번째칸 숫자를 입력하세요");
			tf1.setText("");
			lab1.setText("");
			tf2.setText("");
			res.setText("");
			return;
		}
		result = checkDigit(tf2.getText());
		if(!result) {
			JOptionPane.showMessageDialog(null, "두번째칸 숫자를 입력하세요");
			lab1.setText("");
			tf2.setText("");
			res.setText("");
			return;
		}
		double num1 = Integer.parseInt(tf1.getText());
		double num2 = Integer.parseInt(tf2.getText());
		double sum = 0;
		if(o.equals("+")) {
			lab1.setText("+");
			sum = num1+num2;
			res.setText(sum+"");
		}else if(o.equals("-")) {
			lab1.setText("-");
			sum = num1-num2;
			res.setText(sum+"");
		}else if(o.equals("*")) {
			lab1.setText("*");
			sum = num1*num2;
			res.setText(sum+"");
		}else if(o.equals("/")) {
			lab1.setText("/");
			if(num2 == 0) {
				JOptionPane.showMessageDialog(null, "0으로 나눌수 없습니다.");
				return;
			}
			sum = num1/num2;
			res.setText(sum+"");
		}else {
			tf1.setText("");
			lab1.setText("");
			tf2.setText("");
			res.setText("");
		}
	}
	boolean checkDigit(String conv) {
		boolean chkresult = true;
		try {
			Integer.parseInt(conv);
		}catch (Exception e) {
			chkresult = false;
		}
		return chkresult;
	}

}
