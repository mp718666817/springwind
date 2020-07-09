package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil{
	public static Date getDate(String str,String pt) {
		SimpleDateFormat dFormat = new SimpleDateFormat(pt);
		try {
			return dFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getTime(String str,String pt)
	{
		Long long1 = Long.parseLong(str);
		Date date = new Date(long1);
		SimpleDateFormat dateFormat = new SimpleDateFormat(pt);
		return dateFormat.format(date);
	}
}
