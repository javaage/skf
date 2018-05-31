package com.skf.management.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String FORMATTER = "yyyy-MM-dd";
	private static SimpleDateFormat sdf = new SimpleDateFormat(FORMATTER);

	public static String Date2String(Date date) {
		return sdf.format(date);
	}

}
