package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
	public static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	public static void showMenu() {
		System.out.println("1.회원가입 2.전체출력 3.이름으로검색 4.회원수정 5.회원삭제 6.종료:");
	}
}
