package mypackage;

import java.util.HashMap;
import java.util.Iterator;

public class Practice1 {
	public static void main(String[] args) {
		HashMap<Integer,String> hash = calledMethod();
		System.out.println(hash);
		Iterator<Integer> it = hash.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key + ":"+hash.get(key));
		}
	}
	static HashMap<Integer,String> calledMethod(){
		HashMap<Integer,String> hash = new HashMap<Integer,String>();
		hash.put(2018, "kor");
		return hash;
	}
}
