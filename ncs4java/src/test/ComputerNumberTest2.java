package test;

import java.io.*;
import java.util.Scanner;

public class ComputerNumberTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int kor=0,mat=0,res=0;
		boolean flag = false;
		do {
			try {
				flag=false;
				System.out.println("��������:");
				kor=Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				System.out.println("�������Է�");
				flag=true;
			}
		}while(flag);
		do {
			try {
				flag=false;
				System.out.println("��������:");
				mat=Integer.parseInt(in.readLine());
				int result = kor / mat;
			} catch (ArithmeticException ae) {
				System.out.println("0���� �� ����");
			} catch (Exception e) {
				System.out.println("�������Է�");
				flag=true;
			}	
		}while(flag);
		System.out.println((kor+mat)/2);
	}
}
