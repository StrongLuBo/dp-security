package com.luzhibo.dp.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 * @author 89754
 */
public class DateUtils {
	
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final SimpleDateFormat PATTERN_ONE = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 格式："yyyyMMddHHmmss"
	 *
	 * @return
	 */
	public static String getCurrentDate() {
		return PATTERN_ONE.format(new Date());
	}


	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}
	
}
