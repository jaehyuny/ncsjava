package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import entities.Member;
import service.MemberDaoService;

public class MemberInsertClick implements ActionListener {
	DefaultTableModel model;
	JTextField name;
	JTextField age;
	JTextField gender;
	JTextField delrow;
	
	MemberInsertClick(DefaultTableModel model, JTextField name, JTextField age, JTextField gender, JTextField delrow){
		this.model=model;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.delrow=delrow;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String btntxt = arg0.getActionCommand();
		if(btntxt.equals("입력")) {
			Object row[] = {"","",""};
			row[0]=name.getText();
			row[1]=age.getText();
			row[2]=gender.getText();
			name.setText("");
			age.setText("");
			gender.setText("");
		}
		if(btntxt.equals("호출")) {
			MemberDaoService obj = new MemberDaoService();
			Member data = obj.memberSelectOne(delrow.getText());
			if(data.getName() != null) {
				Object row[] = {"","",""};
				row[0]=data.getName();
				row[1]=data.getBirthday();
				row[2]=data.getGender();
				model.addRow(row);
//				System.out.println(data.getName()+"\t"+data.getBirthday()+"\t"+data.getGender());
			}else {
				JOptionPane.showMessageDialog(null, "null");
			}
//			try {
//				int num = Integer.parseInt(delrow.getText());
//				model.removeRow(num-1);
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, "null");
//			}
//			delrow.setText("");
		}
		
	}

}
