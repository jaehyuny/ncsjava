package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Member;
import service.MemberDaoService;

public class MemberDBInsertListener implements ActionListener {
	String beforeemail;
	String afteremail;
	boolean confirmchk;
	DefaultTableModel model;
	JTable table;
	JTextField idtxt;
	JLabel idlabel;
	JPasswordField pwtxt;
	JPasswordField pwtxt2;
	JTextField nmtxt;
	JTextField pntxt1;
	JTextField pntxt2;
	JTextField pntxt3;
	JTextField sctxt;
	MemberDBInsertListener(boolean confirmchk, DefaultTableModel model, JTable table, JTextField idtxt, JLabel idlabel, JPasswordField pwtxt, JPasswordField pwtxt2, JTextField nmtxt, JTextField pntxt1, JTextField pntxt2, JTextField pntxt3, JTextField sctxt){
		this.confirmchk=confirmchk;
		this.model=model;
		this.table=table;
		this.idtxt=idtxt;
		this.idlabel=idlabel;
		this.pwtxt=pwtxt;
		this.pwtxt2=pwtxt2;
		this.nmtxt=nmtxt;
		this.pntxt1=pntxt1;
		this.pntxt2=pntxt2;
		this.pntxt3=pntxt3;
		this.sctxt=sctxt;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String strbtn = e.getActionCommand();
		if(strbtn.equals("입력")) {
			memberInsert();
		}
		if(strbtn.equals("중복검사")) {
			beforeemail=idtxt.getText();
			confirmChk();
		}
		if(strbtn.equals("검색")) {
			memberSearch();
		}
	}
	void confirmChk() {
		MemberDaoService obj = new MemberDaoService();
		boolean result = obj.memberConfirm(idtxt.getText());
		if(result) {
//			JOptionPane.showMessageDialog(null, "사용할수 없는 id");
			idlabel.setText("사용할수 없는 id");
			return;
		}else {
			confirmchk=true;
//			JOptionPane.showMessageDialog(null, "사용할수 있는 id");
			idlabel.setText("사용할수 있는 id");
			pwtxt.requestFocus();
			return;
		}
	}
	void memberInsert() {
		afteremail=idtxt.getText();
		if(!confirmchk) {
			JOptionPane.showMessageDialog(null, "중복체크를 해주세요");
			return;
		}
		if(idtxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "please email insert");
			return;
		}
		if(nmtxt.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "please name insert");
			return;
		}
		if(!beforeemail.equals(afteremail)) {
	         JOptionPane.showMessageDialog(null, "중복검사를 다시 하세요!");
	         confirmchk=false;
	         return;
	    }
		if(!pwtxt.getText().equals(pwtxt2.getText())) {
	         JOptionPane.showMessageDialog(null, "비밀번호가 맞지않습니다");
	         return;
	    }
		Member data = new Member();
		data.setEmail(idtxt.getText());
		data.setPassword(pwtxt.getText());
		data.setName(nmtxt.getText());
		data.setPhone1(pntxt1.getText());
		data.setPhone2(pntxt2.getText());
		data.setPhone3(pntxt3.getText());
		MemberDaoService obj = new MemberDaoService();
		int saveresult = obj.memberInsert(data);
		if(saveresult > 0) {
			JOptionPane.showMessageDialog(null, "save");
			Object row[] = {"","",""};
			row[0]=data.getEmail();
			row[1]=data.getName();
			row[2]=data.getPhone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
			model.addRow(row);
			confirmchk=false;
			idtxt.setText("");
			pwtxt.setText("");
			pwtxt2.setText("");
			nmtxt.setText("");
			pntxt1.setText("");
			pntxt2.setText("");
			pntxt3.setText("");
			return;
		}else {
			JOptionPane.showMessageDialog(null, "fail");
			return;
		}
	}
	void memberSearch() {
		MemberDaoService obj = new MemberDaoService();
		model.setRowCount(0);
		ArrayList<Member> list1 = obj.memberSearch(sctxt.getText());
		Object row[] = {"","",""};
		for(Member list:list1) {
			row[0] = list.getEmail();
			row[1] = list.getName();
			row[2] = list.getPhone1()+"-"+list.getPhone2()+"-"+list.getPhone3();
			model.addRow(row);
		}
	}

}
