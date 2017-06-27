package hitwh.fanghh.manage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private static SimpleDateFormat yearAndMonthFormat  = new SimpleDateFormat("yyyy/MM");
	//private static SimpleDateFormat monthAndDayFormat = new SimpleDateFormat("MM/dd");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss");
	
	public static String getCurrentDateTime() {
		
		return dateTimeFormat.format(new Date());
	}
	
	public static String getdateTime(Date date){
		 return dateTimeFormat.format(date);
	}
	
	public static String getCurrentDate(){
		
		return dateFormat.format(new Date());
		
	}
	
	public static String getDate(Date date){
		
		return dateFormat.format(date);
	}
	
	
	public static String getYearAndMonth(Date date){
		
		return yearAndMonthFormat.format(date);
	}
	
	public static String getCurrentYearAndMonth(){
		
		return yearAndMonthFormat.format(new Date());
	}
	
	public static Date getYearAndMonth(String str) throws ParseException{
		if((str!= null)&&(str.trim().length()>0))
		return yearAndMonthFormat.parse(str);
		return null;
	}
	
	public static Date getDate(String str) throws ParseException{
		if((str!= null)&&(str.trim().length()>0))
			return dateFormat.parse(str);
			return null;
	}
	
	public static Date getdateTime(String str) throws ParseException{
		if((str!= null)&&(str.trim().length()>0))
			return dateTimeFormat.parse(str);
			return null;
	}
	
	public static int compareDate(String date1,String date2){
		try {
			Long t1 =getDate(date1).getTime();
			Long t2 = getDate(date2).getTime();
			if(t1 > t2)return 1;
			else if(t1 < t2)return -1;
			else return 0;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("String to date failure");
		}
		return 0;
	}
	
	
	
	
}
