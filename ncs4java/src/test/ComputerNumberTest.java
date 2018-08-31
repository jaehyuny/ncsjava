package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ComputerNumberTest {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		System.out.println(System.in.read());
		int money,price,count;
		System.out.println("money");
		money=Integer.parseInt(in.readLine());
//		money=sc.nextInt();
		System.out.println("price");
		price=Integer.parseInt(in.readLine());
		
		
		if(price==0)
			throw new ArithmeticException();
		count=money/price;
		System.out.println("result:"+count);
		
	}
}
