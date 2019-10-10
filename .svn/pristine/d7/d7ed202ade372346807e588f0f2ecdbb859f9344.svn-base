package com.java1234.util;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.commonj.ScheduledTimerListener;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 日期工具类
 * @author Administrator
 */
public class DateUtil {

	public static void main(String s[]) throws Exception{
		
		System.out.println(compareTo("2019", "2018"));
		
	}
	
	/**
	 * yyyyMMdd hhmmssSSS
	 * 日期对象转字符串
	 */
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	
	/**
	 * 字符串转日期对象
	 * @param str
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date formatString(String str,String format) throws Exception{
		if(StringUtil.isEmpty(str)){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	
	public static String getCurrentDateStr()throws Exception{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	
	
	/**
	 * 输入一个月份，2017-01
	 * 输出   2017-01-31
	 */
	public static String getDays(String str){
		str = addMonth2(str, 1);
		str = str+"-01";//2017-02-01
		str = addDay(str, -1);
		System.out.println(str);
		return str;
	}
	
	
	/**
	 * 年月日  加一天
	 */
	public static String addDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			
			cd.add(Calendar.DATE, n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月
			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}
	
	
	/**
	 * 年月   加一月
	 */
		public static String addMonth2(String s, int n) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Calendar cd = Calendar.getInstance();
				cd.setTime(sdf.parse(s));

				cd.add(Calendar.MONTH, n);// 增加一个月
				return sdf.format(cd.getTime());

			} catch (Exception e) {
				return null;
			}
		}
	
	
		/**
		 * 年月日  增加1月
		 */
		public static String addMonth(String s, int n) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cd = Calendar.getInstance();
				cd.setTime(sdf.parse(s));
				// cd.add(Calendar.DATE, n);// 增加一天
				cd.add(Calendar.MONTH, n);// 增加一个月
				return sdf.format(cd.getTime());

			} catch (Exception e) {
				return null;
			}
		}
		
		
		/**
		 * 算2个时间差几分
		 * @param end
		 * @param begin
		 * @return
		 */
		public static long date_between(Date end,Date begin ){
			/*SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   Date begin=dfs.parse("2004-01-02 11:30:24");
			   Date end = dfs.parse("2004-01-02 11:31:40");*/
			   long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
			   long min=between/60;
			   System.out.println("差几分"+min);
			   return min;
		}
		
		
		/**
		 *  任意格式的日期
		 * @param date1
		 * @param date2
		 * @return 1比2大 返回1   相等返回0   小于返回-1
		 */
		public static int compareTo(String date1,String date2){
			return date1.compareTo(date2);
		}
		
}
