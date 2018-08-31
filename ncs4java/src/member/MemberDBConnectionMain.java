package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MemberDBConnectionMain {

	public static void main(String[] args) {
		boolean confirmchk = false;
		JFrame frame = new JFrame("File Read");
		frame.setPreferredSize(new Dimension(1000, 400));
		frame.setLocation(300, 200);
		Font font20 = new Font("굴림", Font.TYPE1_FONT, 12);
		Container contentPane = frame.getContentPane();
		String colNames[] = {"email", "name", "phone"};
//		Object data[][] = { {"김철수", 24, '남'},
//							{"이순희", 21, '여'},
//							{"박지영", 26, '여'} };
		DefaultTableModel model = new DefaultTableModel(colNames,0);
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.CYAN);
		header.setFont(new Font("굴림",Font.TYPE1_FONT, 15));
		table.setFont(font20);
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();
		JButton insert = new JButton("입력");
		JButton modify = new JButton("수정");
		JButton delete = new JButton("삭제");
		JTextField sctxt = new JTextField(8);
		JButton search = new JButton("검색");
		JButton cancel = new JButton("취소");
		GridLayout grid = new GridLayout(9,2);
		JPanel panel2 = new JPanel();
		panel2.setLayout(grid);
		JLabel id = new JLabel("ID");
		id.setHorizontalAlignment(JLabel.CENTER);
		JLabel idlabel = new JLabel();
		id.setHorizontalAlignment(JLabel.CENTER);
		JLabel pw = new JLabel("비밀번호");
		pw.setHorizontalAlignment(JLabel.CENTER);
		JLabel pw2 = new JLabel("비밀번호확인");
		pw2.setHorizontalAlignment(JLabel.CENTER);
		JLabel nm = new JLabel("이름");
		nm.setHorizontalAlignment(JLabel.CENTER);
		JLabel pn = new JLabel("전화번호");
		pn.setHorizontalAlignment(JLabel.CENTER);
		JLabel adn = new JLabel("우편번호");
		adn.setHorizontalAlignment(JLabel.CENTER);
		JLabel ad = new JLabel("주소");
		ad.setHorizontalAlignment(JLabel.CENTER);
		JTextField idtxt = new JTextField(10);
		JPasswordField pwtxt = new JPasswordField(10);
		JPasswordField pwtxt2 = new JPasswordField(10);
		JTextField nmtxt = new JTextField(10);
		JTextField pntxt1 = new JTextField(3);
		pntxt1.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	              char c = e.getKeyChar();
	              if (!(Character.isDigit(c) ||
	                  (c == KeyEvent.VK_BACK_SPACE) ||
	                  (c == KeyEvent.VK_DELETE))) {
	                   e.consume();
	                   JOptionPane.showMessageDialog(null, "숫자만 입력하세요!");
	              }
	         }
	      });
		JTextField pntxt2 = new JTextField(4);
		JTextField pntxt3 = new JTextField(4);
		JTextField adntxt = new JTextField(10);
		JTextField adtxt1 = new JTextField(10);
		JTextField adtxt2 = new JTextField(10);
		JButton idbtn = new JButton("중복검사");
		panel2.add(id);
		JPanel panelwith1 = new JPanel();
		panelwith1.add(idtxt);
		panelwith1.add(idbtn);
		panel2.add(panelwith1);
		panel2.add(new JLabel());
		panel2.add(idlabel);
		panel2.add(pw);
		panel2.add(pwtxt);
		panel2.add(pw2);
		panel2.add(pwtxt2);
		panel2.add(nm);
		panel2.add(nmtxt);
		panel2.add(pn);
		JPanel panelwith2 = new JPanel();
		panelwith2.add(pntxt1);
		panelwith2.add(new JLabel("-"));
		panelwith2.add(pntxt2);
		panelwith2.add(new JLabel("-"));
		panelwith2.add(pntxt3);
		panel2.add(panelwith2);
		panel2.add(adn);
		panel2.add(adntxt);
		panel2.add(ad);
		panel2.add(adtxt1);
		panel2.add(new JLabel(""));
		panel2.add(adtxt2);
		panel.add(insert);
		panel.add(modify);
		panel.add(delete);
		panel.add(sctxt);
		panel.add(search);
		panel.add(cancel);
		ActionListener btnlistener = new MemberDBInsertListener(confirmchk, model, table, idtxt, idlabel, pwtxt, pwtxt2, nmtxt, pntxt1, pntxt2, pntxt3, sctxt);
		MouseListener mouseclick = new MemberGuiMouseListener(model, table, idtxt, idlabel, pwtxt, nmtxt, pntxt1, pntxt2, pntxt3);
		insert.addActionListener(btnlistener);
		idbtn.addActionListener(btnlistener);
		search.addActionListener(btnlistener);
		table.addMouseListener(mouseclick);
//		String arrbtn[] = {"입력","수정","삭제","검색","취소"};
//	      JPanel panel = new JPanel();
//	      JTextField find = new JTextField(9);
//	      find.setFont(font);
//	      JButton button;
//	      for ( int i = 0 ; i < arrbtn.length ; i++ ) {
//	         button = new JButton( arrbtn[i]);
//	         panel.add(button);
//	         
//	         if (i == 2)
//	            panel.add(find);
//	         
//	      }
		contentPane.add(scrollPane, BorderLayout.EAST);
		contentPane.add(panel2, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
