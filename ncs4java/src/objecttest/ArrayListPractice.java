package objecttest;

import java.util.ArrayList;

import entities.Member;

public class ArrayListPractice {
	Member data;
	ArrayList<Member> arrayListGet() {
		ArrayList<Member> list = new ArrayList<Member>();
		data = new Member();
		data.setEmail("a@a.com");
		data.setPassword("1111");
		data.setName("korea");
		data.setPhone1("010");
		list.add(data);
		data = new Member();
		data.setEmail("b@b.com");
		data.setPassword("2222");
		data.setName("usa");
		data.setPhone1("010");
		list.add(data);
		return list;
	}
}
