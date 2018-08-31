package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HitPlay extends JPanel implements ActionListener{
	BaseballTeam team = new BaseballTeam();
	HashMap<Integer,String> hanhwab = team.hanHwaBat();
	HashMap<Integer,String> hanhwap = team.hanHwaPit();
	HashMap<Integer,String> kiab = team.kiaBat();
	JButton hit = new JButton("타격");
	JButton wait = new JButton("기다림");
	JButton bunt = new JButton("번트");
	JButton run = new JButton("도루");
	JButton hitandrun = new JButton("히트 앤 런");
	JButton runandhit = new JButton("런 앤 히트");
	ImageIcon field = new ImageIcon("d:\\util\\문학야구장.jpg");
	JTextArea cast = new JTextArea(6,10);
	public static final int batting = 100;
	public static final int NONE=0;
	
	int cmd = 0;
	int st =1;
	int nd =1;
	int s =0;
	int b =0;
	int o =0;
	int h = 0;
	int p = 0;
	int num = 1;
	int hscore=0;
	int ascore=0;
	boolean tf = false;
	String inning = "회초";
	JLabel inn = new JLabel(num+inning);
	JLabel hs = new JLabel(ascore+"");
	JLabel col = new JLabel(":");
	JLabel as = new JLabel(hscore+"");
	String[] out = { "좌익수 플라이", "중견수 플라이", "우익수 플라이", "1루수 정면", "2루수 정면", "유격수 정면"
			,"3루수 정면","투수 정면", "포수 플라이", "헛스윙 삼진"};
	String[] oneh = { "좌익수 앞", "우익수 앞", "중견수 앞", "내야", "텍사스"};
	String[] twoh = {"좌익수 뒤","우익수 뒤","중견수 뒤","좌익선상","우익선상"};
	String[] hr = {"좌익수 뒤로 넘어가는","우익수 뒤로 넘어가는","중견수 뒤로 넘어가는","경기장 밖으로 넘어가는 장외"};
	String[] count = {"바깥쪽 높은공","바깥쪽 낮은공","바깥쪽 높은 변화구","바깥쪽 낮은 변화구",
			"몸쪽 높은공","몸쪽 낮은공","몸쪽 높은 변화구","몸쪽 낮은 변화구","높은공","낮은공"};
	Random random = new Random();
	
	public HitPlay() {
		setLayout(new BorderLayout());
		buttonChange();
		buttonEnable(tf);
		GridLayout grid2 = new GridLayout(1,1);
		cast.setText("기아와 한화의 경기 중계해드리겠습니다\n"
				+ "기아의 선발투수 헥터와 한화의 선발투수 샘슨이 맞붙겠습니다\n"
				+ "1회초 한화의 공격으로 경기 시작됩니다\n");
		
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
		ImageIcon field = new ImageIcon("d:\\util\\문학야구장.jpg");
	}
	
	public void buttonEnable(boolean b) { 
		run.setEnabled(b);
		hitandrun.setEnabled(b);
		runandhit.setEnabled(b);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(hit)) {
			hitBall();
		}
		if(e.getSource().equals(wait)) {
			waitBall();
		}
		if(e.getSource().equals(bunt)) {
			bunt();
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
		base.put(0, "없음");
		base.put(1, "1루");
		base.put(2, "1,2루");
		base.put(3, "만루");
		base.put(4, "2루");
		base.put(5, "3루");
		base.put(6, "1,3루");
		base.put(7, "2,3루");
		
		if(num<=9) {
			cast.setText(cast.getText()+"\n주자 "+base.get(h));
			as.setText(ascore+"");
			hs.setText(hscore+"");
			inn.setText(num+inning);
			if(o<3) {
				cast.setText(cast.getText()+"\n\n"+ball.get(b)+strike.get(s)+" "+o+"OUT");
			}
			if(o>3) {
				cast.setText(cast.getText()+"\n\n"+ball.get(b)+strike.get(s)+" "+(o-4)+"OUT");
			}
		}
		if(num>9) {
			tf = false;
			cast.setText(cast.getText()+"\n\n경기 끝");
			inn.setText("경기종료");
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
	public void buttonChange() {
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
	}
	public void hitBall() {
		if(o<3) {
			hitBallMethod(hanhwab);
		}
		if(o>3) {
			hitBallMethod(kiab);
		}
	}
	public void waitBall() {
		if(o<3) {
			waitBallMethod(hanhwab);
		}
		if(o>3) {
			waitBallMethod(kiab);
		}
	}
	public void bunt() {
		if(o<3) {
			buntMethod(hanhwab);
		}
		if(o>3) {
			buntMethod(kiab);
		}
	}
	public void hitBallMethod(HashMap<Integer,String> team) {
			cast.setText(st+"번타자 "+team.get(st)+"\n"+ "타격\n");
			if(cast.getText().contains(team.get(st))) {
				if(random.nextInt(batting)<50) {
					String temp = getRandArr(out);
					cast.setText(cast.getText()+temp+" 아웃됩니다");
					if(st<9) {
						st++;
					}else {
						st=1;
					}
					s=0;
					b=0;
					o++;
				}else if(random.nextInt(batting)<65) {
					cast.setText(cast.getText()+"파울");
					if(s==2) {
						s=2;
					}else {
						s++;
					}
				}else if(random.nextInt(batting)<83) {
					String temp = getRandArr(oneh);
					cast.setText(cast.getText()+temp+" 안타");
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
				}else if(random.nextInt(batting)<93) {
					String temp = getRandArr(twoh);
					cast.setText(cast.getText()+temp+" 2루타");
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
				}else if(random.nextInt(batting)<98) {
					String temp = getRandArr(hr);
					cast.setText(cast.getText()+temp+" 홈런!!");
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
					cast.setText(cast.getText()+temp+" 3루타");
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
			if(o==3) {
				cast.setText(cast.getText()+"\n"+"공수교대!");
				inning="회말";
				h=0;
				s=0;
				b=0;
				o++;
			}
			if(o==7) {
				cast.setText(cast.getText()+"\n"+"공수교대!");
				inning="회초";
				h=0;
				s=0;
				b=0;
				o=0;
				num++;
			}
	}
	public void waitBallMethod(HashMap<Integer,String> team) {
		cast.setText(st+"번타자 "+team.get(st)+"\n"+ "지켜봅니다\n");
		String temp = getRandArr(count);
		if(cast.getText().contains(team.get(st))) {
			if(random.nextInt(batting)<50) {
				cast.setText(cast.getText()+temp+" 들어옵니다");
				s++;
			}else {
				cast.setText(cast.getText()+temp+" 빠집니다");
				b++;
			}
		}
		if(s==3) {
			cast.setText(cast.getText()+" 루킹 삼진아웃!");
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
			cast.setText(cast.getText()+" 볼넷!");
			s=0;
			b=0;
			h++;
			if(st<9) {
				st++;
			}else {
				st=1;
			}
		}
		if(o==3) {
			cast.setText(cast.getText()+"\n"+"공수교대!");
			inning="회말";
			h=0;
			s=0;
			b=0;
			o++;
		}
		if(o==7) {
			cast.setText(cast.getText()+"\n"+"공수교대!");
			inning="회초";
			h=0;
			s=0;
			b=0;
			o=0;
			num++;
		}
	}
	public void buntMethod(HashMap<Integer, String> team) {
		cast.setText(st+"번타자 "+team.get(st)+"\n"+ "번트댑니다\n");
		String temp = getRandArr(count);
		if(cast.getText().contains(team.get(st))) {
			if(random.nextInt(batting)<30) {
				cast.setText(cast.getText()+temp+" 파울이네요");
				s++;
			}else if(random.nextInt(batting)<40){
				cast.setText(cast.getText()+temp+" 번트 플라이 아웃됩니다");
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
						cast.setText(cast.getText()+temp+" 기습번트 성공");
						h=1;
					}else {
						cast.setText(cast.getText()+temp+" 기습번트 실패");
						h=0;
						o++;
					}
				}else if(h==1) {
					if(random.nextInt(batting)<80) {
						cast.setText(cast.getText()+temp+" 희생번트 성공");
						h=4;
						o++;
					}else {
						cast.setText(cast.getText()+temp+" 수비 실책으로 주자 올 세이프!!");
						h=2;
					}
				}else if(h==2) {
					if(random.nextInt(batting)<80) {
						cast.setText(cast.getText()+temp+" 희생번트 성공");
						h=7;
						o++;
					}else {
						cast.setText(cast.getText()+temp+" 수비 실책으로 주자 올 세이프!!");
						h=3;
					}
				}else if(h==3) {
					if(random.nextInt(batting)<50) {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 성공!!");
						h=3;
						ascore++;
					}else {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 실패!!");
						h=3;
						o++;
					}
				}else if(h==4) {
					if(random.nextInt(batting)<80) {
						cast.setText(cast.getText()+temp+" 희생번트 성공");
						h=5;
						o++;
					}else {
						cast.setText(cast.getText()+temp+" 수비 실책으로 주자 올 세이프!!");
						h=7;
					}
				}else if(h==5) {
					if(random.nextInt(batting)<50) {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 성공!!");
						h=1;
						ascore++;
					}else {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 실패!!");
						h=1;
						o++;
					}
				}else if(h==6) {
					if(random.nextInt(batting)<50) {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 성공!!");
						h=2;
						ascore++;
					}else {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 실패!!");
						h=2;
						o++;
					}
					ascore++;
				}else if(h==7) {
					if(random.nextInt(batting)<50) {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 성공!!");
						h=6;
						ascore++;
					}else {
						cast.setText(cast.getText()+temp+" 스퀴즈번트 실패!!");
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
		if(o==3) {
			cast.setText(cast.getText()+"\n"+"공수교대!");
			inning="회말";
			h=0;
			s=0;
			b=0;
			o++;
		}
		if(o==7) {
			cast.setText(cast.getText()+"\n"+"공수교대!");
			inning="회초";
			h=0;
			s=0;
			b=0;
			o=0;
			num++;
		}
	}
	public void fourseamMethod(HashMap<Integer,String> team) {
		cast.setText("선발투수 "+team.get(st)+"\n"+ p +"구 던집니다\n");
		String temp = getRandArr(count);
		if(cast.getText().contains(team.get(st))) {
			if(random.nextInt(batting)<50) {
				cast.setText(cast.getText()+temp+" 들어옵니다");
				s++;
			}else {
				cast.setText(cast.getText()+temp+" 빠집니다");
				b++;
			}
		}
	}
}
