package mypackage;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer sb =new StringBuffer();
		sb.append("하늘을 우러러 한점 부끄럼이\n");
		sb.append("입새에 이는 바람에도...");
		System.out.println(sb);
		String str = "하늘을 우러러 한점 부끄럼이 \n";
		str+="입새에 이는 바람에도...";
		System.out.println(str);
	}
}
