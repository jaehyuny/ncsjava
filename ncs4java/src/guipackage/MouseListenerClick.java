package guipackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MouseListenerClick implements MouseListener {
	JComboBox area2;
	JTextField tf2;
	MouseListenerClick(JComboBox area2, JTextField tf2){
		this.area2 = area2;
		this.tf2 = tf2;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		try {
			tf2.setText(area2.getSelectedItem().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "파일을 검색하세요");
			return;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
