package guipackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyClickEventClass implements ActionListener {
	JTextField text;
	JLabel label;
	MyClickEventClass(JTextField text, JLabel label){
		this.text = text;
		this.label = label;
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
//		System.out.println("click"+text.getText());
		label.setText(text.getText());
		text.setText("");
	}

}
