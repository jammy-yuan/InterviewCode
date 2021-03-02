package com.gec.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String dateToStr(Date date) {
		if( date!=null ){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format( date );
		}
		return null;
	}
	public static Date strToDate(String _sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(_sDate);
		} catch (ParseException e) {
			System.out.println("{TypeUtils} Exception");
		}
		return null;
	}
	
	public static int calculateDays(Date d1, Date d2) {
		long t2 = d2.getTime();
		long t1 = d1.getTime();
		int days = (int)((t2 - t1)/1000/(60*60*24));
		return days;
	}
	
	
}
