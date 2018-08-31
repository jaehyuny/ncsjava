package member;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfirmListener implements FocusListener {
	JTextField idtxt;
	JLabel id;
	ConfirmListener(JTextField idtxt, JLabel id){
		this.idtxt=idtxt;
		this.id=id;
	}
	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
