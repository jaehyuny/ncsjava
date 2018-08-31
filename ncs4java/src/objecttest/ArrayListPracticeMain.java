package objecttest;

import java.util.ArrayList;

import entities.Member;

public class ArrayListPracticeMain {

	public static void main(String[] args) {
		ArrayListPractice obj = new ArrayListPractice();
		ArrayList<Member> list = obj.arrayListGet();
//		Member data = null;
//		for(int i=0; i<list.size(); i++) {
//			data = new Member();
//			data = list.get(i);
//			System.out.println(data.getEmail()+" "+data.getPassword()+" "+data.getName()+" "+data.getPhone1());
//		}
		for(Member list1:list) {
			System.out.println(list1.getEmail()+" "+list1.getPassword()+" "+list1.getName()+" "+list1.getPhone1());
		}
	}

}
