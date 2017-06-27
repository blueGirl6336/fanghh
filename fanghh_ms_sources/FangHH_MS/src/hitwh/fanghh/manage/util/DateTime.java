package hitwh.fanghh.manage.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateTime {
	
	private static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	private static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy/MM");
	
	private static SimpleDateFormat dayAndMonthFormat = new SimpleDateFormat("MM/dd");
	
	/**
	 * 获取时间 
	 * 年月日 时分秒格式
	 * @return
	 */
	
	public static String getNow() {
		return DateFormat.getDateTimeInstance(2, 2, getLocale()).format(
				new java.util.Date());
	}
	
	
	/**
	 * 获取当天日期
	 * yyyy/MM/DD格式
	 * @return
	 */
	public static String getToday(){
		return dayFormat.format(new Date());
	}
	
	private static Locale getLocale() {
		return Locale.CHINESE;
	}
	
	/**
	 * 获取月
	 * @return
	 */
	public static String getMonth(){
		return monthFormat.format(new Date());
	}
	
	/**
	 * 获取月和日
	 * @return
	 */
	public static String getMonthAndDay(){
		return dayAndMonthFormat.format(new Date());
	}
	
	/**
	 * 比较两个日期
	 * 
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 输入：指定日期，字符串格式
	 * 输出：指定日期的第二天，字符串格式
	 */
	public static String nextDay(String dataString){
		Calendar c=Calendar.getInstance();
		Date date=null;
		try {
			date=dayFormat.parse(dataString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setTime(date);
		c.set(Calendar.DATE, (c.get(Calendar.DATE) + 1));
		String nextDay=dayFormat.format(c.getTime());
		return nextDay;
	}
	
	/**
	 * 输入：指定日期，字符串格式; 年份year
	 * 输出：指定日期的第year后的前一天日期，字符串格式
	 * eg： 2014/12/09 3年之后到期时间 2014/12/08
	 */
	public static String yearsAfterDay(String dataString, int year){
		Calendar c=Calendar.getInstance();
		Date date=null;
		try {
			date=dayFormat.parse(dataString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setTime(date);
		//几年后
		c.set(Calendar.YEAR, (c.get(Calendar.YEAR) + year));
		//前一天
		c.set(Calendar.DATE, (c.get(Calendar.DATE) - 1));
		String yearsAfterDay=dayFormat.format(c.getTime());
		return yearsAfterDay;
	}
	
	/*public static void main(String[] args) {
		System.out.println(yearsAfterDay("2000/03/01",3));
	}*/
	
}
