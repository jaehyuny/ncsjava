package objectpackage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class NewPractice {
	public static void main(String[] args) {
		MyDateFormat mdf = new MyDateFormat();
		String today = mdf.nowDateDefault();
		System.out.println(today);
		today = mdf.simpleDateToday();
		StringCompare obj = new StringCompare();
		String com1 = obj.moveString("자바");
		String com2 = obj.moveString("자바");
		if(com1.equals(com2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	}
}
