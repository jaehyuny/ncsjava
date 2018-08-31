package mypackage;

import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		ArrayList<Integer> list1=calledMethod(list);
		for(Integer list2:list1) {
			System.out.println(list2);
		}
	}
	static ArrayList<Integer> calledMethod(ArrayList<Integer> list) {
		list.remove(3);
		list.add(70);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
}
