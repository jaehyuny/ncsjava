package test;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.MemberDAO;
import jdbc.MemberDTO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class GuiFrame extends JFrame {

	private JPanel contentPane;
	private JTable table = new JTable();
	private JTextField tfNo;
	private JTextField tfId;
	private JTextField tfTel;
	private JTextField tfName;
	private JTextField tfAddr;
	
	JButton btAdd = new JButton("ADD");
	JButton btFind = new JButton("FIND");
	JButton btAll = new JButton("ALL");
	JButton btDel = new JButton("DELETE");
	JButton btCancel = new JButton("CANCLE");
	JPanel RightBottomPanel;
	//테이블 모델
	DefaultTableModel model = new DefaultTableModel();
	//버튼 상수 정하기
	public static final int NONE=0;
	public static final int ADD=1;
	public static final int DEL=2;
	public static final int FIND=3;
	public static final int ALL=4;
	
	int cmd = 0;
	MemberDAO dao = new MemberDAO();
	

	public GuiFrame() {
		initGUI();
		start();
	
	}
	public void initGUI() {
		
		setBounds(100, 100, 644, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LeftPanels = new JPanel();
		LeftPanels.setBounds(5, 5, 156, 311);
		contentPane.add(LeftPanels);
		LeftPanels.setLayout(null);
		
		JLabel lblNo = new JLabel("NO");
		lblNo.setBounds(12, 10, 18, 15);
		LeftPanels.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setBounds(12, 29, 116, 28);
		LeftPanels.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 70, 41, 15);
		LeftPanels.add(lblId);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(12, 88, 116, 28);
		LeftPanels.add(tfId);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(12, 129, 41, 15);
		LeftPanels.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(12, 148, 116, 28);
		LeftPanels.add(tfName);
		
		JLabel lblTel = new JLabel("TEL");
		lblTel.setBounds(12, 189, 41, 15);
		LeftPanels.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(12, 207, 116, 28);
		LeftPanels.add(tfTel);
		
		JLabel lblAddr = new JLabel("ADDR");
		lblAddr.setBounds(12, 245, 41, 15);
		LeftPanels.add(lblAddr);
		
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(12, 263, 116, 28);
		LeftPanels.add(tfAddr);
		
		JPanel RightPanels = new JPanel();
		RightPanels.setBounds(173, 5, 443, 374);
		contentPane.add(RightPanels);
		RightPanels.setLayout(null);
		
		JPanel RightTopPanel = new JPanel();
		RightTopPanel.setBounds(0, 0, 443, 327);
		RightPanels.add(RightTopPanel);
		RightTopPanel.setLayout(new BoxLayout(RightTopPanel, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		RightTopPanel.add(scrollPane);
		
		table = new JTable();
		//scrollPane.setViewportView(table);
		scrollPane.setViewportView(this.table);
		
/*		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"회원번호", "아이디", "이름", "전화번호", "주소"
			}
		));*/
		
	
		
		RightBottomPanel = new JPanel();
		RightBottomPanel.setBounds(0, 326, 443, 48);
		RightPanels.add(RightBottomPanel);
		RightBottomPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		
		
		model.addColumn("회원번호");
		model.addColumn("아 이 디");
		model.addColumn("이    름");
		model.addColumn("전화번호");
		model.addColumn("주    소");
		
		//model을 view와 연결
		table.setModel(model);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.YELLOW);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);
		
		initialTf();
	
	} // End initGUI...
	
	public void start() {
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		RightBottomPanel.add(btAdd);
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("actionPerformed()");
				if(cmd!=ADD) {
					setEnabled(ADD);
					tfId.requestFocus();
				}else {
					add();
					setEnabled(NONE);
					cmd=NONE;
					initialTf();
					clearTf();
				}
			}
		});
	}
	public void setEnabled(int n) {
		boolean b = false;
		this.initialBt(b);
		switch(n) {
		case ADD:
			btAdd.setEnabled(!b);
			btCancel.setEnabled(!b);
			cmd=ADD;
			break;
		case DEL:
			btDel.setEnabled(!b);
			btCancel.setEnabled(!b);
			cmd=DEL;
			break;
		case FIND:
			btFind.setEnabled(!b);
			btCancel.setEnabled(!b);
			cmd=FIND;
			break;
		case ALL:
			btAll.setEnabled(!b);
			btCancel.setEnabled(!b);
			cmd=ALL;
			break;
		}
		this.setEditable(cmd);
	}
	public void initialBt(boolean b) {
		btAdd.setEnabled(b);
		btDel.setEnabled(b);
		btAll.setEnabled(b);
		btFind.setEnabled(b);
		btCancel.setEnabled(b);
	}
	public void clearTf() {
		tfNo.setText("");
		tfId.setText("");
		tfName.setText("");
		tfTel.setText("");
		tfAddr.setText("");
	}
	public void add() {
		MemberDTO dto = new MemberDTO();
		System.out.println("save");
		String id = tfId.getText();
		String name=tfName.getText();
		String tel = tfTel.getText();
		String addr = tfAddr.getText();
		
	}
	public void initialTf() {
		boolean b = false;
		tfNo.setEditable(b);
		tfId.setEditable(b);
		tfName.setEditable(b);
		tfTel.setEditable(b);
		tfAddr.setEditable(b);
	}
	public void setEditable(int n) {
		boolean b = false;
		switch(n) {
			case ADD:
				tfId.setEditable(!b);
				tfName.setEditable(!b);
				tfTel.setEditable(!b);
				tfAddr.setEditable(!b);
				clearTf();
				break;
			case FIND:
				tfName.setEditable(!b);
				break;
			case DEL:
				tfId.setEditable(!b);
				break;
			case NONE:
			case ALL:
				initialTf();
				break;
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GuiFrame frame = new GuiFrame();
				frame.setVisible(true);
			}
		});
	}
}

