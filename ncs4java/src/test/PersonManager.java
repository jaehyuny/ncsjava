package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dto.PersonDTO;

public class PersonManager {
//	String name;
//	int num;
//	double avg;
	PersonDTO dto = new PersonDTO();
	public void input() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("name:");
		String name=in.readLine();
		System.out.println("number:");
		int num = Integer.parseInt(in.readLine());
		System.out.println("avg:");
		double avg = Double.parseDouble(in.readLine());
		dto.setName(name);
		dto.setNum(num);
		dto.setAvg(avg);
	}

	public void print() {
		System.out.println(dto.getName());
		System.out.println(dto.getNum());
		System.out.println(dto.getAvg());
	}

}
