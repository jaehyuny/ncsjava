package member;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Member;
import service.MemberDaoService;

public class MemberGuiMouseListener implements MouseListener {
	DefaultTableModel model;
	JTable table;
	JTextField idtxt;
	JPasswordField pwtxt;
	JTextField nmtxt;
	JTextField pntxt1;
	JTextField pntxt2;
	JTextField pntxt3;
	MemberGuiMouseListener(DefaultTableModel model, JTable table, JTextField idtxt, JLabel idlabel, JPasswordField pwtxt, JTextField nmtxt, JTextField pntxt1, JTextField pntxt2, JTextField pntxt3) {
		this.model=model;
		this.table=table;
		this.idtxt=idtxt;
		this.pwtxt=pwtxt;
		this.nmtxt=nmtxt;
		this.pntxt1=pntxt1;
		this.pntxt2=pntxt2;
		this.pntxt3=pntxt3;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable target = (JTable) e.getSource();
		int row = target.getSelectedRow();
		String email = (String) target.getValueAt(row, 0);
		String name = (String) target.getValueAt(row, 1);
		MemberDaoService obj = new MemberDaoService();
		Member data = obj.memberSelectOne(email);
//		idtxt.setText(email);
//		nmtxt.setText(name);
		this.idtxt.setText(data.getEmail());
		this.pwtxt.setText(data.getPassword());
		this.nmtxt.setText(data.getName());
		this.pntxt1.setText(data.getPhone1());
		this.pntxt2.setText(data.getPhone2());
		this.pntxt3.setText(data.getPhone3());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
