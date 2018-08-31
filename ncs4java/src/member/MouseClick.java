package member;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MouseClick implements MouseListener {
	DefaultTableModel model;
	JTable table;
	JTextField delrow;
	MouseClick(DefaultTableModel model, JTable table, JTextField delrow){
		this.model=model;
		this.delrow=delrow;
		this.table=table;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		JTable target = (JTable) arg0.getSource();
		int row = target.getSelectedRow();
		delrow.setText(row+1+"");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
