package com.platform.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化
 * @author qiu
 * @date 2018-5-7
 */
public class DateUtils {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 时间格式化
	 * String --> Date
	 * @param date 时间
	 * @param format 格式
	 * @return
	 */
	public static Date parseDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 日期
	 * @param date 时间类型
	 * @return 格式化时间
	 */
	public static String formatDate(Date date) {
		return DATE_FORMAT.format(date);
	}
	
	/**
	 * 时间
	 * @param time 时间类型
	 * @return 格式化时间
	 */
	public static String formatTime(Date time) {
		return TIME_FORMAT.format(time);
	}
	
	/**
	 * 转换为时间格式
	 * @param date 字符串是时间  yyyy-MM-dd
	 * @return 时间类型
	 * @exception ParseException 异常
	 */
	public static Date parseDate(String date) throws ParseException{
		return DATE_FORMAT.parse(date);
	}
	
	/**
	 * 转换为时间格式
	 * @param time 字符串时间 时间格式 yyyy-MM-dd HH:mm:ss
	 * @return 时间类型
	 * @exception ParseException 异常
	 */
	public static Date parseTime(String time) throws ParseException{
		return TIME_FORMAT.parse(time);
	}
	
}
