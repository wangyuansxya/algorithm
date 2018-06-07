package com.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtil {
	public static String getDate(int field, int value) {
		SimpleDateFormat format = new SimpleDateFormat("dd");
		GregorianCalendar a = new GregorianCalendar();
		a.add(field, value);
		String valueOf = String.valueOf(format.format(a.getTime()));
		return valueOf;
	}

	public static String getWeek(int field, int value) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		GregorianCalendar a = new GregorianCalendar();
		a.add(field, value);
		String valueOf = String.valueOf(format.format(a.getTime())).replace("星期", "");
		return valueOf;
	}
	
	public static String getTime(int field, int value, String format1) {
		SimpleDateFormat format = new SimpleDateFormat(format1);
		GregorianCalendar a = new GregorianCalendar();
		a.add(field, value);
		return format.format(a.getTime());
	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        System.out.println(zero.getTime());
	}

}
