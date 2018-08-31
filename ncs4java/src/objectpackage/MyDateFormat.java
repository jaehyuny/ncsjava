package objectpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MyDateFormat {
	String nowDateDefault() {
		Calendar calendar = new GregorianCalendar();
		TimeZone timezone = TimeZone.getDefault();
		calendar.setTimeZone(timezone);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		int ampm = calendar.get(Calendar.AM_PM);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		String str = year+"/"+month+"/"+date+" ";
		if(ampm==0) {
			str += "����";
		}else {
			str += "����";
		}
		str +=" "+hour+":"+min;
		return str;
	}
	String simpleDateToday() {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY�� MM�� dd�� HH:MM:ss");
		String daytimes = formatter.format(today);
		return daytimes;
	}
}
