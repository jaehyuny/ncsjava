package mypackage;

public class StringReturnDemo {
	public static void main(String[] args) {
		String str1 = "java";
		String str2 = "spring";
		String str3 = "summer";
		String[] result = stringAppend(str1,str2,str3);
		for(String result1:result) {
			System.out.print(result1);
		}
		System.out.println();
		int[] arrresult = arrReturn();
		for(int arrresult1:arrresult) {
			System.out.print(arrresult1+"\t");
		}
		System.out.println();
		StringBuffer aa = new StringBuffer();
		aa.append("adsfadf");
		aa.append(2388948);
		aa.append("gogogogogo");
		System.out.println(aa);
	}
	static String[] stringAppend(String fir, String sec, String app) {
		String str = fir +","+ sec +","+ app;
		String[] arrstr = str.split(",");
		
		StringBuffer sb = new StringBuffer();
		sb.append(fir);
		sb.append(",");
		sb.append(sec);
		sb.append(app);
		String str2 = sb.toString();
		String[] arrsb=str2.split(",");
		for(int i=0; i<arrsb.length; i++) {
			System.out.println(arrsb[i]);
		}
		return arrstr;
	}
	static int[] arrReturn() {
		int arr[] = {30,10,90,60};
		return arr;
	}
}
