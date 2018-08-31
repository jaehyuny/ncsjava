package guipackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class LayoutDemoMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame("LayoutDemo");
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setLocation(500, 200);
		Container contentPane = frame.getContentPane();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel4 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JButton("btn1"));
		panel1.add(new JButton("btn2"));
		panel1.add(new JButton("btn3"));
		panel1.add(new JButton("btn4"));
		panel2.add(new JButton("btn1"));
		panel2.add(new JButton("btn2"));
		panel2.add(new JButton("btn3"));
		panel2.add(new JButton("btn4"));
		GridLayout grid = new GridLayout(3,2);
		JPanel panel3 = new JPanel();
		panel3.setLayout(grid);
		panel3.add(new JButton("grid1"));
		panel3.add(new JButton("grid2"));
		panel3.add(new JButton("grid3"));
//		panel3.add(new JButton("grid4"));
		JPanel panelwith = new JPanel();
		panelwith.add(new JComboBox<>());
		panelwith.add(new JCheckBox());
		panelwith.add(new JTextField(4));
		panel3.add(panelwith);
		panel3.add(new JButton("grid5"));
		panel3.add(new JButton("grid6"));
		panel4.add(new JScrollBar());
		contentPane.add(panel1, BorderLayout.CENTER);
		contentPane.add(panel2, BorderLayout.SOUTH);
		contentPane.add(panel3, BorderLayout.WEST);
		contentPane.add(panel4, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

