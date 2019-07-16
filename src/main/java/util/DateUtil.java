package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 * @author RanJi
 *
 */
public class DateUtil {
	/**
	 * 用某种时间格式，格式化字符串
	 * @param date  时期
	 * @param formatStr	格式
	 * @return 按给定格式格式化后的时间字符串
	 */
	public static String formatDate(Date date, String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		String result = sdf.format(date);
		return result;
	}
	/**
	 * 按给定格式把指定的字符串转化为时间
	 * @param formatStr
	 * @param value
	 * @return
	 */
	public static Date parseDate(String formatStr, String value){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args) {
		System.out.println(formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(parseDate("yyyy-MM-dd","2018-08-19"));
	}
}
