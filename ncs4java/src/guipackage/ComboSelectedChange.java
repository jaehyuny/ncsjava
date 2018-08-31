package guipackage;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboSelectedChange implements ItemListener {
	JComboBox area2;
	JTextField tf2;
	ComboSelectedChange(JComboBox area2, JTextField tf2){
		this.area2 = area2;
		this.tf2 = tf2;
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		tf2.setText(arg0.getItem().toString());
	}

}
