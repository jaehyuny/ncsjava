package jdbc;

import java.io.IOException;

public class MemberMenu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int sel=0;
		while(true) {
			Menu.showMenu();
			sel=Integer.parseInt(Menu.in.readLine());
			switch(sel) {
			case 1:
				System.out.println("ют╥б");
				break;
			case 6:
				System.out.println("exit");
				System.exit(0);
			}
		}
	}

}
