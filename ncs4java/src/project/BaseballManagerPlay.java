package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import dbpool.DBConnectionManager;
import entities.PlayerAVG;

public class BaseballManagerPlay extends JPanel implements ActionListener{
	DBConnectionManager db = DBConnectionManager.getInstance();
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	BaseballTeam team = new BaseballTeam();
	HashMap<Integer,String> hanhwab = team.hanHwaBat();
	HashMap<Integer,String> hanhwap = team.hanHwaPit();
	HashMap<Integer,String> kiab = team.kiaBat();
	HashMap<Integer,String> kiap = team.kiaPit();
	JButton hit = new JButton("Ÿ��");
	JButton wait = new JButton("��ٸ�");
	JButton bunt = new JButton("��Ʈ");
	JButton run = new JButton("����");
	JButton hitandrun = new JButton("��Ʈ �� ��");
	JButton runandhit = new JButton("�� �� ��Ʈ");
	ImageIcon field = new ImageIcon("d:\\util\\���о߱���.jpg");
	JTextArea cast = new JTextArea(8,10);
	public static final int batting = 100;
	public static final int NONE=0;
	
	int cmd = 0;
	int st =1;
	int nd =1;
	int pitst = 1;
	int pitnd = 1;
	int s =0;
	int b =0;
	int o =0;
	int h = 0;
	int pst = 1;
	int pnd = 1;
	int num = 1;
	int hscore=0;
	int ascore=0;
	boolean tf = false;
	String inning = "ȸ��";
	JLabel inn = new JLabel(num+inning);
	JLabel as = new JLabel("��ȭ "+ascore);
	JLabel col = new JLabel(":");
	JLabel hs = new JLabel(hscore+" ���");
	String[] out = { "���ͼ� �ö���", "�߰߼� �ö���", "���ͼ� �ö���", "1��� ����", "2��� ����", "���ݼ� ����"
			,"3��� ����","���� ����", "���� �ö���", "�꽺�� ����"};
	String[] oneh = { "���ͼ� ��", "���ͼ� ��", "�߰߼� ��", "����", "�ػ罺"};
	String[] twoh = {"���ͼ� ��","���ͼ� ��","�߰߼� ��","���ͼ���","���ͼ���"};
	String[] hr = {"���ͼ� �ڷ� �Ѿ��","���ͼ� �ڷ� �Ѿ��","�߰߼� �ڷ� �Ѿ��","����� ������ �Ѿ�� ���"};
	String[] count = {"�ٱ��� ������","�ٱ��� ������","�ٱ��� ���� ��ȭ��","�ٱ��� ���� ��ȭ��",
			"���� ������","���� ������","���� ���� ��ȭ��","���� ���� ��ȭ��","������","������"};
	Random random = new Random();
	
	public BaseballManagerPlay() {
		setLayout(new BorderLayout());
		GridLayout grid = new GridLayout(3,2);
		JPanel panel1 = new JPanel();
		panel1.setLayout(grid);
		panel1.add(hit);
		panel1.add(wait);
		panel1.add(bunt);
		panel1.add(run);
		panel1.add(hitandrun);
		panel1.add(runandhit);
		add("East", panel1);
		buttonEnable(tf);
		GridLayout grid2 = new GridLayout(1,1);
		cast.setText("��ƿ� ��ȭ�� ��� �߰��ص帮�ڽ��ϴ�\n"
				+ "����� �������� ���Ϳ� ��ȭ�� �������� ������ �ºٰڽ��ϴ�\n"
				+ "1ȸ�� ��ȭ�� �������� ��� ���۵˴ϴ�\n");
		
		JScrollPane scrollpane1 = new JScrollPane(cast);
		JPanel panel2 = new JPanel();
		panel2.setLayout(grid2);
		panel2.add(scrollpane1);
		add("South", panel2);
		JPanel panel3 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(field.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		add("Center", panel3);
		JPanel panel4 = new JPanel();
		panel4.add(inn);
		panel4.add(as);
		panel4.add(col);
		panel4.add(hs);
		add("North", panel4);
		hit.addActionListener(this);
		wait.addActionListener(this);
		bunt.addActionListener(this);

	}
	public void baseballManagerPlay() {
		ImageIcon field = new ImageIcon("d:\\util\\���о߱���.jpg");
	}
	
	public void buttonEnable(boolean b) { 
		run.setEnabled(b);
		hitandrun.setEnabled(b);
		runandhit.setEnabled(b);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(hit)) {
			if(hit.getText().equals("Ÿ��")) {
				hitBall();
			}else {
				strike();
			}
		}
		if(e.getSource().equals(wait)) {
			if(wait.getText().equals("��ٸ�")) {
				waitBall();
			}else {
				ball();
			}
		}
		if(e.getSource().equals(bunt)) {
			if(bunt.getText().equals("��Ʈ")) {
				bunt();
			}else {
				pickoffMethod();
			}
		}
		if(h!=0) {
			tf=true;
			buttonEnable(tf);
		}else {
			tf=false;
			buttonEnable(tf);
		}
		HashMap<Integer, String> strike = new HashMap<Integer, String>();
		strike.put(0, "0S");
		strike.put(1, "1S");
		strike.put(2, "2S");
		HashMap<Integer, String> ball = new HashMap<Integer, String>();
		ball.put(0, "0B");
		ball.put(1, "1B ");
		ball.put(2, "2B ");
		ball.put(3, "3B ");
		HashMap<Integer, String> base = new HashMap<Integer, String>();
		base.put(0, "����");
		base.put(1, "1��");
		base.put(2, "1,2��");
		base.put(3, "����");
		base.put(4, "2��");
		base.put(5, "3��");
		base.put(6, "1,3��");
		base.put(7, "2,3��");
		if(num<=9) {
			cast.setText(cast.getText()+"\n���� "+base.get(h));
			hs.setText(hscore+" ���");
			as.setText("��ȭ "+ascore);
			inn.setText(num+inning);
			if(o<3) {
				cast.setText(cast.getText()+"\n\n"+ball.get(b)+strike.get(s)+" "+o+"OUT");
			}
			if(o>3) {
				cast.setText(cast.getText()+"\n\n"+ball.get(b)+strike.get(s)+" "+(o-4)+"OUT");
			}
		}else {
				tf = false;
				cast.setText(cast.getText()+"\n\n��� ��");
				inn.setText("�������");
				hit.setEnabled(tf);
				wait.setEnabled(tf);
				bunt.setEnabled(tf);
				buttonEnable(tf);
		}
	}
	private static String getRandArr(String[] arr) {
        return arr[getRand(arr.length - 1)]; 
    }
 
	private static int getRand(int n) {
		Random r = new Random();
		int result = r.nextInt(n);
        return result;
    }
	public void buttonChangePitch() {
		hit.setText("��Ʈ����ũ");
		wait.setText("��");
		bunt.setText("��ġ�ƿ�");
		run.setText("����");
		runandhit.setText("");
		hitandrun.setText("");
	}
	public void buttonChangeHit() {
		hit.setText("Ÿ��");
		wait.setText("��ٸ�");
		bunt.setText("��Ʈ");
		run.setText("����");
		runandhit.setText("��Ʈ �� ��");
		hitandrun.setText("�� �� ��Ʈ");
	}
	public void hitBall() {
			pitchMethod(kiap);
			hitBallMethod(hanhwab);
	}
	public void waitBall() {
			pitchMethod(kiap);
			waitBallMethod(hanhwab);
	}
	public void bunt() {
			pitchMethod(kiap);
			buntMethod(hanhwab);
	}
	public void strike() {
		pitchMethod(hanhwap);
		strikeMethod(kiab);
	}
	public void ball() {
		pitchMethod(hanhwap);
		ballMethod(kiab);
	}
	public void hitBallMethod(HashMap<Integer,String> team) {
		PlayerAVG data = new PlayerAVG();
		PlayerRecord pr = new PlayerRecord();
		if(o<3) {
			cast.setText(cast.getText()+st+"��Ÿ�� "+team.get(st)+"\n"+ "Ÿ��\n");
			if(cast.getText().contains(team.get(st))) {
				if(random.nextInt(batting)<40) {
//					data.setTeam("��ȭ");
//					data.setName(team.get(st));
//					int saveresult = pr.playeravgInsert(data);
//					if(saveresult > 0) {
//						Object row[] = {"",""};
//						row[0]=data.getTeam();
//						row[1]=data.getName();
//					}
					String temp = getRandArr(out);
					cast.setText(cast.getText()+temp+" �ƿ��˴ϴ�");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					s=0;
					b=0;
					o++;
				}else if(random.nextInt(batting)<60) {
					cast.setText(cast.getText()+"�Ŀ�");
					if(s==2) {
						s=2;
					}else {
						s++;
					}
				}else if(random.nextInt(batting)<76) {
					String temp = getRandArr(oneh);
					cast.setText(cast.getText()+temp+" ��Ÿ");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					if(h==0) {
						h=1;
					}else if(h==1) {
						h=2;
					}else if(h==2) {
						h=3;
					}else if(h==3) {
						h=3;
						ascore++;
					}else if(h==4) {
						h=6;
					}else if(h==5) {
						h=1;
						ascore++;
					}else if(h==6) {
						h=2;
						ascore++;
					}else if(h==7) {
						h=6;
						ascore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<88) {
					String temp = getRandArr(twoh);
					cast.setText(cast.getText()+temp+" 2��Ÿ");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					if(h==0) {
						h=4;
					}else if(h==1) {
						h=7;
					}else if(h==2) {
						h=7;
						ascore++;
					}else if(h==3) {
						h=7;
						ascore++;
						ascore++;
					}else if(h==4) {
						h=4;
						ascore++;
					}else if(h==5) {
						h=4;
						ascore++;
					}else if(h==6) {
						h=7;
						ascore++;
					}else if(h==7) {
						h=4;
						ascore++;
						ascore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<97) {
					String temp = getRandArr(hr);
					cast.setText(cast.getText()+temp+" Ȩ��!!");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					if(h==0) {
						h=0;
						ascore++;
					}else if(h==1) {
						h=0;
						ascore++;
						ascore++;
					}else if(h==2) {
						h=0;
						ascore++;
						ascore++;
						ascore++;
					}else if(h==3) {
						h=0;
						ascore++;
						ascore++;
						ascore++;
						ascore++;
					}else if(h==4) {
						h=0;
						ascore++;
						ascore++;
					}else if(h==5) {
						h=0;
						ascore++;
						ascore++;
					}else if(h==6) {
						h=0;
						ascore++;
						ascore++;
						ascore++;
					}else if(h==7) {
						h=0;
						ascore++;
						ascore++;
						ascore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<=100) {
					String temp = getRandArr(twoh);
					cast.setText(cast.getText()+temp+" 3��Ÿ");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					if(h==0) {
						h=5;
					}else if(h==1) {
						h=5;
						ascore++;
					}else if(h==2) {
						h=5;
						ascore++;
						ascore++;
					}else if(h==3) {
						h=5;
						ascore++;
						ascore++;
						ascore++;
					}else if(h==4) {
						h=5;
						ascore++;
					}else if(h==5) {
						h=5;
						ascore++;
					}else if(h==6) {
						h=5;
						ascore++;
						ascore++;
					}else if(h==7) {
						h=5;
						ascore++;
						ascore++;
					}
					s=0;
					b=0;
				}
			}
		}else if(o>3) {
			cast.setText(cast.getText()+nd+"��Ÿ�� "+team.get(nd)+"\n"+ "Ÿ��\n");
			if(cast.getText().contains(team.get(nd))) {
				if(random.nextInt(batting)<40) {
					String temp = getRandArr(out);
					cast.setText(cast.getText()+temp+" �ƿ��˴ϴ�");
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					s=0;
					b=0;
					o++;
				}else if(random.nextInt(batting)<60) {
					cast.setText(cast.getText()+"�Ŀ�");
					if(s==2) {
						s=2;
					}else {
						s++;
					}
				}else if(random.nextInt(batting)<76) {
					String temp = getRandArr(oneh);
					cast.setText(cast.getText()+temp+" ��Ÿ");
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					if(h==0) {
						h=1;
					}else if(h==1) {
						h=2;
					}else if(h==2) {
						h=3;
					}else if(h==3) {
						h=3;
						hscore++;
					}else if(h==4) {
						h=6;
					}else if(h==5) {
						h=1;
						hscore++;
					}else if(h==6) {
						h=2;
						hscore++;
					}else if(h==7) {
						h=6;
						hscore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<88) {
					String temp = getRandArr(twoh);
					cast.setText(cast.getText()+temp+" 2��Ÿ");
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					if(h==0) {
						h=4;
					}else if(h==1) {
						h=7;
					}else if(h==2) {
						h=7;
						hscore++;
					}else if(h==3) {
						h=7;
						hscore++;
						hscore++;
					}else if(h==4) {
						h=4;
						hscore++;
					}else if(h==5) {
						h=4;
						hscore++;
					}else if(h==6) {
						h=7;
						hscore++;
					}else if(h==7) {
						h=4;
						hscore++;
						hscore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<98) {
					String temp = getRandArr(hr);
					cast.setText(cast.getText()+temp+" Ȩ��!!");
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					if(h==0) {
						h=0;
						hscore++;
					}else if(h==1) {
						h=0;
						hscore++;
						hscore++;
					}else if(h==2) {
						h=0;
						hscore++;
						hscore++;
						hscore++;
					}else if(h==3) {
						h=0;
						hscore++;
						hscore++;
						hscore++;
						hscore++;
					}else if(h==4) {
						h=0;
						hscore++;
						hscore++;
					}else if(h==5) {
						h=0;
						hscore++;
						hscore++;
					}else if(h==6) {
						h=0;
						hscore++;
						hscore++;
						hscore++;
					}else if(h==7) {
						h=0;
						hscore++;
						hscore++;
						hscore++;
					}
					s=0;
					b=0;
				}else if(random.nextInt(batting)<=100) {
					String temp = getRandArr(twoh);
					cast.setText(cast.getText()+temp+" 3��Ÿ");
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					if(h==0) {
						h=5;
					}else if(h==1) {
						h=5;
						hscore++;
					}else if(h==2) {
						h=5;
						hscore++;
						hscore++;
					}else if(h==3) {
						h=5;
						hscore++;
						hscore++;
						hscore++;
					}else if(h==4) {
						h=5;
						hscore++;
					}else if(h==5) {
						h=5;
						hscore++;
					}else if(h==6) {
						h=5;
						hscore++;
						hscore++;
					}else if(h==7) {
						h=5;
						hscore++;
						hscore++;
					}
					s=0;
					b=0;
				}
			}
		}
		if(o==3) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangePitch();
			h=0;
			s=0;
			b=0;
			o++;
		}
		if(o==7) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangeHit();
			h=0;
			s=0;
			b=0;
			o=0;
			num++;
		}
		}
	public void waitBallMethod(HashMap<Integer,String> team) {
		if(o<3) {
			cast.setText(cast.getText()+st+"��Ÿ�� "+team.get(st)+"\n"+ "���Ѻ��ϴ�\n");
			String temp = getRandArr(count);
			if(cast.getText().contains(team.get(st))) {
				if(random.nextInt(batting)<50) {
					cast.setText(cast.getText()+temp+" ���ɴϴ�");
					s++;
				}else {
					cast.setText(cast.getText()+temp+" �����ϴ�");
					b++;
				}
			}
			if(s==3) {
				cast.setText(cast.getText()+" ��ŷ �����ƿ�!");
				s=0;
				b=0;
				o++;
				if(st<9) {
					st++;
				}else {
					st=1;
				}
			}
			if(b==4) {
				cast.setText(cast.getText()+" ����!");
				s=0;
				b=0;
				h++;
				if(st<9) {
					st++;
				}else {
					st=1;
				}
			}
		}else {
			cast.setText(cast.getText()+nd+"��Ÿ�� "+team.get(nd)+"\n"+ "���Ѻ��ϴ�\n");
			String temp = getRandArr(count);
			if(cast.getText().contains(team.get(nd))) {
				if(random.nextInt(batting)<50) {
					cast.setText(cast.getText()+temp+" ���ɴϴ�");
					s++;
				}else {
					cast.setText(cast.getText()+temp+" �����ϴ�");
					b++;
				}
			}
			if(s==3) {
				cast.setText(cast.getText()+" ��ŷ �����ƿ�!");
				s=0;
				b=0;
				o++;
				if(nd<9) {
					nd++;
				}else {
					nd=1;
				}
			}
			if(b==4) {
				cast.setText(cast.getText()+" ����!");
				s=0;
				b=0;
				h++;
				if(nd<9) {
					nd++;
				}else {
					nd=1;
				}
			}
		}
		if(o==3) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangePitch();
			h=0;
			s=0;
			b=0;
			o++;
		}
		if(o==7) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangeHit();
			h=0;
			s=0;
			b=0;
			o=0;
			num++;
		}
	}
	public void buntMethod(HashMap<Integer, String> team) {
		if(o<3) {
			cast.setText(cast.getText()+st+"��Ÿ�� "+team.get(st)+"\n"+ "��Ʈ��ϴ�\n");
			String temp = getRandArr(count);
			if(cast.getText().contains(team.get(st))) {
				if(random.nextInt(batting)<30) {
					cast.setText(cast.getText()+temp+" �Ŀ��̳׿�");
					s++;
				}else if(random.nextInt(batting)<40){
					cast.setText(cast.getText()+temp+" ��Ʈ �ö��� �ƿ��˴ϴ�");
					s=0;
					b=0;
					o++;
					if(st<9) {
						st++;
					}else {
						st=1;
					}
				}else {
					if(h==0) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=1;
						}else {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=0;
							o++;
						}
					}else if(h==1) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=4;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=2;
						}
					}else if(h==2) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=7;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=3;
						}
					}else if(h==3) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=3;
							ascore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=3;
							o++;
						}
					}else if(h==4) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=5;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=7;
						}
					}else if(h==5) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=1;
							ascore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=1;
							o++;
						}
					}else if(h==6) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=2;
							ascore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=2;
							o++;
						}
						ascore++;
					}else if(h==7) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=6;
							ascore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=6;
							o++;
						}
					}
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					s=0;
					b=0;
				}
			}
		}else {
			cast.setText(cast.getText()+nd+"��Ÿ�� "+team.get(nd)+"\n"+ "��Ʈ��ϴ�\n");
			String temp = getRandArr(count);
			if(cast.getText().contains(team.get(nd))) {
				if(random.nextInt(batting)<30) {
					cast.setText(cast.getText()+temp+" �Ŀ��̳׿�");
					s++;
				}else if(random.nextInt(batting)<40){
					cast.setText(cast.getText()+temp+" ��Ʈ �ö��� �ƿ��˴ϴ�");
					s=0;
					b=0;
					o++;
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
				}else {
					if(h==0) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=1;
						}else {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=0;
							o++;
						}
					}else if(h==1) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=4;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=2;
						}
					}else if(h==2) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=7;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=3;
						}
					}else if(h==3) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=3;
							hscore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=3;
							o++;
						}
					}else if(h==4) {
						if(random.nextInt(batting)<80) {
							cast.setText(cast.getText()+temp+" �����Ʈ ����");
							h=5;
							o++;
						}else {
							cast.setText(cast.getText()+temp+" ���� ��å���� ���� �� ������!!");
							h=7;
						}
					}else if(h==5) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=1;
							hscore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=1;
							o++;
						}
					}else if(h==6) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=2;
							hscore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=2;
							o++;
						}
						hscore++;
					}else if(h==7) {
						if(random.nextInt(batting)<50) {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=6;
							hscore++;
						}else {
							cast.setText(cast.getText()+temp+" �������Ʈ ����!!");
							h=6;
							o++;
						}
					}
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
					s=0;
					b=0;
				}
				if(s==3) {
					cast.setText(cast.getText()+"\n"+"������Ʈ �ƿ�!");
					s=0;
					b=0;
					o++;
					if(nd<9) {
						nd++;
					}else {
						nd=1;
					}
				}
			}
		}
		if(o==3) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangePitch();
			h=0;
			s=0;
			b=0;
			o++;
		}
		if(o==7) {
			cast.setText(cast.getText()+"\n"+"��������!");
			inning="ȸ��";
			buttonChangeHit();
			h=0;
			s=0;
			b=0;
			o=0;
			num++;
		}
	}
	public void pitchMethod(HashMap<Integer,String> team) {
		if(o<3) {
			cast.setText("�������� "+team.get(pitst)+" "+ pst +"�� �����ϴ�\n");
			pst++;
		}else {
			cast.setText("�������� "+team.get(pitnd)+" "+ pnd +"�� �����ϴ�\n");
			pnd++;
		}
	}
	public void strikeMethod(HashMap<Integer,String> team) {
		if(h==0) {
			if(s<2) {
				if(random.nextInt(batting)<45) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=45 && random.nextInt(batting)<95) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}else {
				if(random.nextInt(batting)<60) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=60 && random.nextInt(batting)<99) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}
		}else {
			if(s<2) {
				if(random.nextInt(batting)<40) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=40 && random.nextInt(batting)<95) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}else {
				if(random.nextInt(batting)<60) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=60 && random.nextInt(batting)<98) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}
		}
	}
	public void ballMethod(HashMap<Integer,String> team) {
		if(h==0) {
			if(s<2) {
				if(random.nextInt(batting)<30) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=30 && random.nextInt(batting)<95) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}else {
				if(random.nextInt(batting)<60) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=60 && random.nextInt(batting)<99) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}
		}else {
			if(s<2) {
				if(random.nextInt(batting)<30) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=30 && random.nextInt(batting)<95) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}else {
				if(random.nextInt(batting)<60) {
					hitBallMethod(team);
				}else if(random.nextInt(batting)>=60 && random.nextInt(batting)<98) {
					waitBallMethod(team);
				}else {
					buntMethod(team);
				}
			}
		}
	}
	public void pickoffMethod() {
		
	}
}