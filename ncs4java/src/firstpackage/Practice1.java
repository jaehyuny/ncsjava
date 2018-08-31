package firstpackage;

import objecttest.ObjectReturnTest;

public class Practice1 {
	public static void main(String[] args) {
		String str = "À¯ÈÄ";
		int num = 3;
		String mov = "AVENGERS";
		int a = 1;
		int ce = 23;
		str = num+"";
		
		str = Integer.toString(num);
		num = Integer.parseInt(str);
		
		System.out.println(str);
		System.out.println(mov);
		System.out.println(num);
		
		String result = apple(mov,num);
		System.out.println(result);
		int ace = onePiece(a,ce);
		System.out.println(ace);
		ObjectReturnTest obj = new ObjectReturnTest();
		obj.objectReturnTest(mov, num);
	}
	static String apple(String app, int bpp) {
		System.out.println(app+"  "+bpp);
		return "4/25 °³ºÀ";
	}
	static int onePiece(int fire, int man) {
		System.out.println(fire+"  "+man);
		return 123;
	}
}
