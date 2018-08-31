package mypackage;

public class StringPractice {
	public static void main(String[] args) {
		String str="korea ";
		str += "I love ";
		int year = 2018;
		str += year;
		String num = "12";
		int sum = year + Integer.parseInt(num);
		str = str.replace("korea", "대한민국");
		String str1 = str.substring(0, 3);
		System.out.println(str1);
		str = str.concat(" 추가");
		System.out.println(str);
		System.out.println(sum);
		System.out.println(str.length());
		str = "a,b,c,d,e,f,g,h,i";
		String[] arrstr = str.split(",");
		for(int i =0; i<arrstr.length; i++) {
			System.out.print(arrstr[i]);
		}
		System.out.println();
		System.out.println(arrstr.length);
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			System.out.print(ch);
		}
		System.out.println();
		
		String str2 = "show";
		if(str1.equals(str2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	}
}
