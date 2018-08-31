package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import dto.PersonDTO;

public class Person2 {
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PersonDTO dto = new PersonDTO();
//		System.out.println("name:");
//		String name=in.readLine();
//		System.out.println("number:");
//		int num = Integer.parseInt(in.readLine());
//		System.out.println("avg:");
//		double avg = Double.parseDouble(in.readLine());
//		dto.setName(name);
//		dto.setNum(num);
//		dto.setAvg(avg);
//		System.out.println(dto.getName()+"\t"+dto.getNum()+"\t"+dto.getAvg());
//		String name2 = dto.getName();
//		System.out.println(name2);
		PersonManager pm = new PersonManager();
		pm.input();
		pm.print();
	}
}
