package guipackage;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FileReadAndWrite implements ActionListener {
	JTextField tf1;
	JTextField tf2;
	JTextArea area1;
	JComboBox area2;
//	ArrayList<String> findlist;
	FileReadAndWrite(JTextField tf1, JTextField tf2, JTextArea area1, JComboBox area2){
		this.tf1 = tf1;
		this.tf2 = tf2;
		this.area1 = area1;
		this.area2 = area2;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String fraw = arg0.getActionCommand();
		BufferedReader br = null;
		File dir = new File(tf1.getText());
		File[] filelist = dir.listFiles();
//		findlist = new ArrayList<String>();
		if(!dir.exists()) {
			JOptionPane.showMessageDialog(null, "경로가 잘못되었습니다");
			return;
		}
		if(fraw.equals("파일검색")) {
//			area2.setText("");
			area2.removeAllItems();
			for(File filelist1:filelist) {
				if(filelist1.isFile()) {
//					findlist.add(filelist1.getName());
//					area2.append(filelist1.getName()+"\n");
					area2.addItem(filelist1.getName());
				}
			}
		}
		
		if(fraw.equals("파일출력")) {
			area1.setText("");
			try {
				br = new BufferedReader(new FileReader(tf1.getText()+"\\"+tf2.getText()));
				String line;
				while((line = br.readLine()) != null) {
					area1.append(line+"\n");
				}
				br.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "파일 이름이 잘못되었습니다");
			}
		}
			
	}
//	void fileView() {
//		BufferedReader br = null;
//		boolean findbol = false;
//		for(String findlist1:findlist) {
//			if(findlist1.equals(tf2.getText())) {
//				findbol = true;
//				break;
//			}
//		}
//		if(!findbol) {
//			JOptionPane.showMessageDialog(null, tf2.getText()+"not exist file");
//			return;
//		}
//		String filename="d:\\"+tf1.getText()+"\\"+tf2.getText();
//		try {
//			br = new BufferedReader(new FileReader(filename));
//			String line;
//			try {
//				while((line = br.readLine()) != null) {
//					area2.append(line+"\n");
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
